/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.stubBased.deserialization

import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import org.jetbrains.kotlin.analysis.low.level.api.fir.caches.getNotNullValueForNotNullContext
import org.jetbrains.kotlin.analysis.low.level.api.fir.project.structure.llFirModuleData
import org.jetbrains.kotlin.analysis.low.level.api.fir.providers.LLFirKotlinSymbolProvider
import org.jetbrains.kotlin.analysis.low.level.api.fir.util.LLFirKotlinSymbolNamesProvider
import org.jetbrains.kotlin.analysis.providers.createDeclarationProvider
import org.jetbrains.kotlin.analysis.providers.createPackageProvider
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.caches.FirCache
import org.jetbrains.kotlin.fir.caches.firCachesFactory
import org.jetbrains.kotlin.fir.caches.getValue
import org.jetbrains.kotlin.fir.declarations.FirDeclarationOrigin
import org.jetbrains.kotlin.fir.deserialization.SingleModuleDataProvider
import org.jetbrains.kotlin.fir.java.deserialization.KotlinBuiltins
import org.jetbrains.kotlin.fir.realPsi
import org.jetbrains.kotlin.fir.resolve.providers.FirSymbolNamesProvider
import org.jetbrains.kotlin.fir.resolve.providers.FirSymbolProviderInternals
import org.jetbrains.kotlin.fir.scopes.FirKotlinScopeProvider
import org.jetbrains.kotlin.fir.symbols.impl.*
import org.jetbrains.kotlin.load.kotlin.FacadeClassSource
import org.jetbrains.kotlin.name.*
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getTopmostParentOfType
import org.jetbrains.kotlin.psi.stubs.impl.*
import org.jetbrains.kotlin.resolve.jvm.JvmClassName
import org.jetbrains.kotlin.serialization.deserialization.builtins.BuiltInSerializerProtocol
import org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedContainerSource
import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty

typealias DeserializedTypeAliasPostProcessor = (FirTypeAliasSymbol) -> Unit

/**
 * [StubBasedFirDeserializedSymbolProvider] works over existing stubs,
 * retrieving them by classId/callableId from [KotlinDeclarationProvider].
 *
 * It works in IDE only, in standalone mode works [JvmClassFileBasedSymbolProvider].
 *
 * Because it works over existing stubs, there is no need to keep huge protobuf in memory.
 * At the same time, there is no need to guess sources for fir elements anymore,
 * they are set during deserialization.
 *
 * Same as [JvmClassFileBasedSymbolProvider], resulting fir elements are already resolved.
 */
internal open class StubBasedFirDeserializedSymbolProvider(
    session: FirSession,
    moduleDataProvider: SingleModuleDataProvider,
    private val kotlinScopeProvider: FirKotlinScopeProvider,
    project: Project,
    scope: GlobalSearchScope,

    // A workaround for KT-63718. It should be removed with KT-64236.
    isFallbackDependenciesProvider: Boolean,
) : LLFirKotlinSymbolProvider(session) {
    private val moduleData = moduleDataProvider.getModuleData(null)

    final override val declarationProvider = project.createDeclarationProvider(
        scope,
        contextualModule = session.llFirModuleData.ktModule.takeIf { !isFallbackDependenciesProvider },
    )

    override val allowKotlinPackage: Boolean get() = true

    override val symbolNamesProvider: FirSymbolNamesProvider =
        LLFirKotlinSymbolNamesProvider.cached(session, declarationProvider, allowKotlinPackage)

    private val typeAliasCache: FirCache<ClassId, FirTypeAliasSymbol?, StubBasedFirDeserializationContext?> =
        session.firCachesFactory.createCacheWithPostCompute(
            createValue = { classId, context -> findAndDeserializeTypeAlias(classId, context) },
            postCompute = { _, symbol, postProcessor ->
                if (postProcessor != null && symbol != null) {
                    postProcessor.invoke(symbol)
                }
            }
        )

    private val classCache: FirCache<ClassId, FirRegularClassSymbol?, StubBasedFirDeserializationContext?> =
        session.firCachesFactory.createCache(
            createValue = { classId, context -> findAndDeserializeClass(classId, context) }
        )

    private val functionCache = session.firCachesFactory.createCache(::loadFunctionsByCallableId)
    private val propertyCache = session.firCachesFactory.createCache(::loadPropertiesByCallableId)

    final override val packageProvider = project.createPackageProvider(scope)

    /**
     * Computes the origin for the declarations coming from [file].
     *
     * We assume that a stub Kotlin declaration might come only from Library or from BuiltIns.
     * We do the decision based upon the extension of the [file].
     *
     * This method is left open so the inheritors can provide more optimal/strict implementations.
     */
    protected open fun getDeclarationOriginFor(file: KtFile): FirDeclarationOrigin {
        val virtualFile = file.virtualFile

        return if (virtualFile.extension == BuiltInSerializerProtocol.BUILTINS_FILE_EXTENSION) {
            FirDeclarationOrigin.BuiltIns
        } else {
            FirDeclarationOrigin.Library
        }
    }

    private fun findAndDeserializeTypeAlias(
        classId: ClassId,
        context: StubBasedFirDeserializationContext?,
    ): Pair<FirTypeAliasSymbol?, DeserializedTypeAliasPostProcessor?> {
        val classLikeDeclaration =
            (context?.classLikeDeclaration ?: declarationProvider.getClassLikeDeclarationByClassId(classId))
        if (classLikeDeclaration is KtTypeAlias) {
            val symbol = FirTypeAliasSymbol(classId)
            val postProcessor: DeserializedTypeAliasPostProcessor = {
                val rootContext = context ?: StubBasedFirDeserializationContext.createRootContext(
                    moduleData,
                    StubBasedAnnotationDeserializer(session),
                    classId.packageFqName,
                    classId.relativeClassName,
                    classLikeDeclaration,
                    null, null, symbol,
                    initialOrigin = getDeclarationOriginFor(classLikeDeclaration.containingKtFile)
                )
                rootContext.memberDeserializer.loadTypeAlias(classLikeDeclaration, symbol)
            }
            return symbol to postProcessor
        }
        return null to null
    }

    private fun findAndDeserializeClass(
        classId: ClassId,
        parentContext: StubBasedFirDeserializationContext?,
    ): FirRegularClassSymbol? {
        val classLikeDeclaration = parentContext?.classLikeDeclaration
            ?: declarationProvider.getClassLikeDeclarationByClassId(classId)
            ?: return null

        val symbol = FirRegularClassSymbol(classId)
        if (classLikeDeclaration is KtClassOrObject) {
            deserializeClassToSymbol(
                classId,
                classLikeDeclaration,
                symbol,
                session,
                moduleData,
                StubBasedAnnotationDeserializer(session),
                kotlinScopeProvider,
                parentContext = parentContext,
                containerSource = JvmStubDeserializedContainerSource(classId),
                deserializeNestedClass = this::getClass,
                initialOrigin = parentContext?.initialOrigin ?: getDeclarationOriginFor(classLikeDeclaration.containingKtFile)
            )

            return symbol
        }
        return null
    }

    private fun loadFunctionsByCallableId(
        callableId: CallableId,
        foundFunctions: Collection<KtNamedFunction>?,
    ): List<FirNamedFunctionSymbol> {
        val topLevelFunctions = foundFunctions ?: declarationProvider.getTopLevelFunctions(callableId)

        return ArrayList<FirNamedFunctionSymbol>(topLevelFunctions.size).apply {
            for (function in topLevelFunctions) {
                val functionStub = function.stub as? KotlinFunctionStubImpl ?: loadStubByElement(function)
                val functionFile = function.containingKtFile
                val containerSource = getContainerSource(functionFile, functionStub?.origin)
                val functionOrigin = getDeclarationOriginFor(functionFile)

                if (functionOrigin != FirDeclarationOrigin.BuiltIns &&
                    containerSource is FacadeClassSource &&
                    containerSource.className.internalName in KotlinBuiltins
                ) {
                    continue
                }

                val symbol = FirNamedFunctionSymbol(callableId)
                val rootContext = StubBasedFirDeserializationContext
                    .createRootContext(session, moduleData, callableId, function, symbol, functionOrigin, containerSource)

                add(rootContext.memberDeserializer.loadFunction(function, null, session, symbol).symbol)
            }
        }
    }

    private fun loadPropertiesByCallableId(callableId: CallableId, foundProperties: Collection<KtProperty>?): List<FirPropertySymbol> {
        val topLevelProperties = foundProperties ?: declarationProvider.getTopLevelProperties(callableId)

        return buildList {
            for (property in topLevelProperties) {
                val propertyStub = property.stub as? KotlinPropertyStubImpl ?: loadStubByElement(property)
                val propertyFile = property.containingKtFile
                val containerSource = getContainerSource(propertyFile, propertyStub?.origin)
                val propertyOrigin = getDeclarationOriginFor(propertyFile)

                val symbol = FirPropertySymbol(callableId)
                val rootContext = StubBasedFirDeserializationContext
                    .createRootContext(session, moduleData, callableId, property, symbol, propertyOrigin, containerSource)

                add(rootContext.memberDeserializer.loadProperty(property, null, symbol).symbol)
            }
        }
    }

    private fun getContainerSource(file: KtFile, origin: KotlinStubOrigin?): DeserializedContainerSource {
        if (getDeclarationOriginFor(file) == FirDeclarationOrigin.BuiltIns) {
            require(origin is KotlinStubOrigin.Facade) {
                "Expected builtins file to have Facade origin, got origin=$origin instead"
            }

            return JvmStubDeserializedBuiltInsContainerSource(
                facadeClassName = JvmClassName.byInternalName(origin.className)
            )
        }

        return when (origin) {
            is KotlinStubOrigin.Facade -> {
                val className = JvmClassName.byInternalName(origin.className)
                JvmStubDeserializedFacadeContainerSource(className, facadeClassName = null)
            }
            is KotlinStubOrigin.MultiFileFacade -> {
                val className = JvmClassName.byInternalName(origin.className)
                val facadeClassName = JvmClassName.byInternalName(origin.facadeClassName)
                JvmStubDeserializedFacadeContainerSource(className, facadeClassName)
            }
            else -> {
                val virtualFile = file.virtualFile
                val classId = ClassId(file.packageFqName, Name.identifier(virtualFile.nameWithoutExtension))
                val className = JvmClassName.byClassId(classId)
                JvmStubDeserializedFacadeContainerSource(className, facadeClassName = null)
            }
        }
    }

    private fun getClass(classId: ClassId, parentContext: StubBasedFirDeserializationContext? = null): FirRegularClassSymbol? =
        if (parentContext?.classLikeDeclaration != null) {
            classCache.getNotNullValueForNotNullContext(classId, parentContext)
        } else {
            classCache.getValue(classId, parentContext)
        }

    private fun getTypeAlias(classId: ClassId, context: StubBasedFirDeserializationContext? = null): FirTypeAliasSymbol? {
        if (!classId.relativeClassName.isOneSegmentFQN()) return null
        return typeAliasCache.getValue(classId, context)
    }

    @FirSymbolProviderInternals
    override fun getTopLevelCallableSymbolsTo(destination: MutableList<FirCallableSymbol<*>>, packageFqName: FqName, name: Name) {
        val callableId = CallableId(packageFqName, name)
        destination += functionCache.getCallablesWithoutContext(callableId)
        destination += propertyCache.getCallablesWithoutContext(callableId)
    }

    private fun <C : FirCallableSymbol<*>, CONTEXT> FirCache<CallableId, List<C>, CONTEXT?>.getCallablesWithoutContext(
        id: CallableId,
    ): List<C> {
        if (!symbolNamesProvider.mayHaveTopLevelCallable(id.packageName, id.callableName)) return emptyList()
        return getValue(id, null)
    }

    @FirSymbolProviderInternals
    override fun getTopLevelCallableSymbolsTo(
        destination: MutableList<FirCallableSymbol<*>>,
        callableId: CallableId,
        callables: Collection<KtCallableDeclaration>,
    ) {
        callables.filterIsInstance<KtNamedFunction>().ifNotEmpty {
            destination += functionCache.getValue(callableId, this)
        }

        callables.filterIsInstance<KtProperty>().ifNotEmpty {
            destination += propertyCache.getValue(callableId, this)
        }
    }

    @FirSymbolProviderInternals
    override fun getTopLevelFunctionSymbolsTo(destination: MutableList<FirNamedFunctionSymbol>, packageFqName: FqName, name: Name) {
        destination += functionCache.getCallablesWithoutContext(CallableId(packageFqName, name))
    }

    @FirSymbolProviderInternals
    override fun getTopLevelFunctionSymbolsTo(
        destination: MutableList<FirNamedFunctionSymbol>,
        callableId: CallableId,
        functions: Collection<KtNamedFunction>,
    ) {
        destination += functionCache.getValue(callableId, functions)
    }

    @FirSymbolProviderInternals
    override fun getTopLevelPropertySymbolsTo(destination: MutableList<FirPropertySymbol>, packageFqName: FqName, name: Name) {
        destination += propertyCache.getCallablesWithoutContext(CallableId(packageFqName, name))
    }

    @FirSymbolProviderInternals
    override fun getTopLevelPropertySymbolsTo(
        destination: MutableList<FirPropertySymbol>,
        callableId: CallableId,
        properties: Collection<KtProperty>,
    ) {
        destination += propertyCache.getValue(callableId, properties)
    }

    override fun getPackage(fqName: FqName): FqName? =
        fqName.takeIf { packageProvider.doesKotlinOnlyPackageExist(fqName) }

    override fun getClassLikeSymbolByClassId(classId: ClassId): FirClassLikeSymbol<*>? {
        if (!symbolNamesProvider.mayHaveTopLevelClassifier(classId)) return null

        classId.takeIf(ClassId::isNestedClass)?.outermostClassId?.let { outermostClassId ->
            // We have to load root declaration to initialize nested classes correctly
            getClassLikeSymbolByClassId(outermostClassId)

            // Nested declarations already loaded
            val computedValue = classCache.getValueIfComputed(classId) ?: typeAliasCache.getValueIfComputed(classId)
            computedValue?.let { return it }
        }

        return getClass(classId) ?: getTypeAlias(classId)
    }

    @FirSymbolProviderInternals
    override fun getClassLikeSymbolByClassId(classId: ClassId, classLikeDeclaration: KtClassLikeDeclaration): FirClassLikeSymbol<*>? {
        val topmostClassLikeDeclaration = classLikeDeclaration.takeIf {
            classId.isNestedClass
        }?.getTopmostParentOfType<KtClassLikeDeclaration>()

        val outermostClassId = topmostClassLikeDeclaration?.getClassId()
        val cache = if (classLikeDeclaration is KtClassOrObject) classCache else typeAliasCache
        if (outermostClassId != null) {
            // We have to load root declaration to initialize nested classes correctly
            getClassLikeSymbolByClassId(outermostClassId, topmostClassLikeDeclaration)

            // Nested declarations already loaded
            cache.getValueIfComputed(classId)?.let { return it }
        }

        val annotationDeserializer = StubBasedAnnotationDeserializer(session)
        val classOrigin = getDeclarationOriginFor(classLikeDeclaration.containingKtFile)
        val deserializationContext = StubBasedFirDeserializationContext(
            moduleData,
            classId.packageFqName,
            classId.relativeClassName,
            StubBasedFirTypeDeserializer(
                moduleData,
                annotationDeserializer,
                parent = null,
                containingSymbol = null,
                owner = null,
                classOrigin
            ),
            annotationDeserializer,
            containerSource = null,
            outerClassSymbol = null,
            outerTypeParameters = emptyList(),
            classOrigin,
            classLikeDeclaration,
        )

        return cache.getNotNullValueForNotNullContext(classId, deserializationContext)
    }

    fun getTopLevelCallableSymbol(
        packageFqName: FqName,
        shortName: Name,
        callableDeclaration: KtCallableDeclaration,
    ): FirCallableSymbol<*>? {
        //possible overloads spoils here
        //we can't use only this callable instead of index access to fill the cache
        //names check is redundant though as we already have existing callable in scope
        val callableId = CallableId(packageFqName, shortName)
        val callableSymbols = when (callableDeclaration) {
            is KtNamedFunction -> functionCache.getValue(callableId)
            is KtProperty -> propertyCache.getValue(callableId)
            else -> null
        }
        return callableSymbols?.singleOrNull { it.fir.realPsi == callableDeclaration }
    }
}
