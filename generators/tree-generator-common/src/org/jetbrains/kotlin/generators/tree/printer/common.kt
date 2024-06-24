/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.generators.tree.printer

import org.jetbrains.kotlin.generators.tree.*
import org.jetbrains.kotlin.generators.tree.config.AbstractBuilderConfigurator
import org.jetbrains.kotlin.generators.tree.config.AbstractImplementationConfigurator
import org.jetbrains.kotlin.generators.tree.imports.ImportCollecting
import org.jetbrains.kotlin.generators.tree.imports.ImportCollector
import org.jetbrains.kotlin.generators.util.GeneratorsFileUtil
import org.jetbrains.kotlin.utils.IndentingPrinter
import org.jetbrains.kotlin.utils.SmartPrinter
import java.io.File

private val COPYRIGHT by lazy { File("license/COPYRIGHT_HEADER.txt").readText() }

class GeneratedFile(val file: File, val newText: String)

private fun getPathForFile(generationPath: File, packageName: String, typeName: String): File {
    val dir = generationPath.resolve(packageName.replace(".", "/"))
    return File(dir, "$typeName.kt")
}

private data class PrinterAndImportCollector(
    val printer: SmartPrinter,
    val importCollector: ImportCollecting,
) : IndentingPrinter by printer,
    ImportCollecting by importCollector,
    ImportCollectingPrinter

fun ImportCollectingPrinter.withNewPrinter(printer: SmartPrinter, body: ImportCollectingPrinter.() -> Unit) {
    PrinterAndImportCollector(printer, this).apply(body)
}

private fun <GeneratedType, TypePrinter> printGeneratedTypesIntoSingleFile(
    generatedTypes: List<GeneratedType>,
    generationPath: File,
    treeGeneratorReadMe: String,
    packageName: String,
    fileNameWithoutExtension: String,
    fileSuppressions: List<String> = emptyList(),
    makeTypePrinter: (ImportCollectingPrinter) -> TypePrinter,
    printType: TypePrinter.(GeneratedType) -> Unit,
): GeneratedFile {
    val stringBuilder = StringBuilder()
    val file = getPathForFile(generationPath, packageName, fileNameWithoutExtension)
    val importCollector = ImportCollector(packageName)
    val printer = PrinterAndImportCollector(SmartPrinter(stringBuilder), importCollector)

    val typePrinter = makeTypePrinter(printer)
    var isFirst = true
    for (generatedType in generatedTypes) {
        if (isFirst) {
            isFirst = false
        } else {
            printer.println()
        }
        typePrinter.printType(generatedType)
    }

    return GeneratedFile(
        file,
        buildString {
            appendLine(COPYRIGHT)
            appendLine()
            append(GeneratorsFileUtil.GENERATED_MESSAGE_PREFIX)
            append(treeGeneratorReadMe)
            appendLine(".")
            appendLine(GeneratorsFileUtil.GENERATED_MESSAGE_SUFFIX)
            appendLine()
            if (fileSuppressions.isNotEmpty()) {
                fileSuppressions.joinTo(this, prefix = "@file:Suppress(", postfix = ")\n\n") { "\"$it\"" }
            }
            appendLine("package $packageName")
            appendLine()
            if (importCollector.printAllImports(this)) {
                appendLine()
            }
            append(stringBuilder)
        }
    )
}

fun printGeneratedType(
    generationPath: File,
    treeGeneratorReadMe: String,
    packageName: String,
    typeName: String,
    fileSuppressions: List<String> = emptyList(),
    body: ImportCollectingPrinter.() -> Unit,
): GeneratedFile =
    printGeneratedTypesIntoSingleFile(
        listOf(null),
        generationPath,
        treeGeneratorReadMe,
        packageName,
        typeName,
        fileSuppressions,
        makeTypePrinter = { it },
        printType = { body() }
    )

/**
 * Used to clean up files in [generationPath] that were not generated by calls to [Context.generateTree].
 *
 * @param generationPath Where to put the generated files.
 * @param treeGeneratorReadme A relative path to the README file of the tree generator. This path is mentioned in the auto-generation
 * warning in each generated file.
 */
class TreeGenerator(private val generationPath: File, private val treeGeneratorReadme: String) {

    fun run(body: Context.() -> Unit) {
        val context = Context()
        body(context)
        val previouslyGeneratedFiles = GeneratorsFileUtil.collectPreviouslyGeneratedFiles(generationPath)
        context.generatedFiles.forEach { GeneratorsFileUtil.writeFileIfContentChanged(it.file, it.newText, logNotChanged = false) }
        GeneratorsFileUtil.removeExtraFilesFromPreviousGeneration(previouslyGeneratedFiles, context.generatedFiles.map { it.file })
    }

    inner class Context internal constructor() {

        internal val generatedFiles = mutableListOf<GeneratedFile>()

        /**
         * The entry point of the tree generator.
         *
         * @param model The configured elements of the tree.
         * @param pureAbstractElement The abstract class for elements that only implement interfaces to inherit from, see [addPureAbstractElement]
         * for details.
         * @param createElementPrinter Provide the class that prints elements, see [AbstractElementPrinter].
         * @param createVisitorPrinters Provide the class that prints various visitors, see [AbstractVisitorPrinter].
         * @param implementationConfigurator The class for configuring the set of implementation classes, see [AbstractImplementation] and
         * [AbstractImplementationConfigurator].
         * @param builderConfigurator The class for configuring the set of builders, see [Builder] and [AbstractBuilderConfigurator].
         * @param createImplementationPrinter Provide the class that prints implementations of elements, see [AbstractImplementationPrinter].
         * @param createBuilderPrinter Provide the class that prints the corresponding builder for each element class, see [AbstractBuilderPrinter].
         * @param enableBaseTransformerTypeDetection Whether to use a special algorithm for inferring return types of transformer methods for each
         * element, see [detectBaseTransformerTypes].
         * @param addFiles Arbitrary files to add to the set of generated files.
         */
        fun <Element, Implementation, ElementField> generateTree(
            model: Model<Element>,
            pureAbstractElement: ClassRef<*>?,
            createElementPrinter: (ImportCollectingPrinter) -> AbstractElementPrinter<Element, ElementField>,
            createVisitorPrinters: List<Pair<ClassRef<*>, (ImportCollectingPrinter, ClassRef<*>) -> AbstractVisitorPrinter<Element, ElementField>>>,
            implementationConfigurator: AbstractImplementationConfigurator<Implementation, Element, ElementField>,
            builderConfigurator: AbstractBuilderConfigurator<Element, Implementation, ElementField>? = null,
            createImplementationPrinter: (ImportCollectingPrinter) -> AbstractImplementationPrinter<Implementation, Element, ElementField>,
            createBuilderPrinter: ((ImportCollectingPrinter) -> AbstractBuilderPrinter<Element, Implementation, ElementField>)? = null,
            enableBaseTransformerTypeDetection: Boolean = true,
            addFiles: MutableList<GeneratedFile>.() -> Unit = {},
            putElementsInSingleFile: Pair<String, String>? = null,
            putImplementationsInSingleFile: Pair<String, String>? = null,
        ) where Element : AbstractElement<Element, ElementField, Implementation>,
                Implementation : AbstractImplementation<Implementation, Element, ElementField>,
                ElementField : AbstractField<ElementField> {
            model.inheritFields()
            if (enableBaseTransformerTypeDetection) {
                detectBaseTransformerTypes(model)
            }
            implementationConfigurator.configureImplementations(model)
            val implementations = model.elements.flatMap { it.implementations }
            InterfaceAndAbstractClassConfigurator((model.elements + implementations))
                .configureInterfacesAndAbstractClasses()

            pureAbstractElement?.let {
                addPureAbstractElement(model.elements, it)
            }

            builderConfigurator?.configureBuilders()

            val elementsToPrint = model.elements.filter { it.doPrint }
            if (putElementsInSingleFile != null) {
                printGeneratedTypesIntoSingleFile(
                    elementsToPrint,
                    generationPath,
                    treeGeneratorReadme,
                    putElementsInSingleFile.first,
                    putElementsInSingleFile.second,
                    makeTypePrinter = createElementPrinter,
                    printType = AbstractElementPrinter<Element, ElementField>::printElement,
                ).let(generatedFiles::add)
            } else {
                elementsToPrint.mapTo(generatedFiles) { element ->
                    printGeneratedType(
                        generationPath,
                        treeGeneratorReadme,
                        element.packageName,
                        element.typeName,
                    ) { createElementPrinter(this).printElement(element) }
                }
            }

            val implementationsToPrint = implementations.filter { it.doPrint }
            if (putImplementationsInSingleFile != null) {
                printGeneratedTypesIntoSingleFile(
                    implementationsToPrint,
                    generationPath,
                    treeGeneratorReadme,
                    putImplementationsInSingleFile.first,
                    putImplementationsInSingleFile.second,
                    fileSuppressions = listOf("DuplicatedCode"),
                    makeTypePrinter = createImplementationPrinter,
                    printType = AbstractImplementationPrinter<Implementation, Element, ElementField>::printImplementation,
                ).let(generatedFiles::add)
            } else {
                implementationsToPrint.mapTo(generatedFiles) { implementation ->
                    printGeneratedType(
                        generationPath,
                        treeGeneratorReadme,
                        implementation.packageName,
                        implementation.typeName,
                        fileSuppressions = listOf("DuplicatedCode"),
                    ) { createImplementationPrinter(this).printImplementation(implementation) }
                }
            }

            if (createBuilderPrinter != null && builderConfigurator != null) {
                (implementations.mapNotNull { it.builder } + builderConfigurator.intermediateBuilders).mapTo(generatedFiles) { builder ->
                    printGeneratedType(
                        generationPath,
                        treeGeneratorReadme,
                        builder.packageName,
                        builder.typeName,
                        fileSuppressions = listOf("DuplicatedCode", "unused"),
                    ) {
                        createBuilderPrinter(this).printBuilder(builder)
                    }
                }
            }

            createVisitorPrinters.mapTo(generatedFiles) { (visitorClass, createVisitorPrinter) ->
                printGeneratedType(generationPath, treeGeneratorReadme, visitorClass.packageName, visitorClass.simpleName) {
                    createVisitorPrinter(this, visitorClass).printVisitor(model.elements)
                }
            }

            generatedFiles.addFiles()
        }
    }
}
