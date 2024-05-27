/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.components

import org.jetbrains.kotlin.analysis.api.lifetime.withValidityAssertion
import org.jetbrains.kotlin.analysis.api.symbols.KaClassOrObjectSymbol
import org.jetbrains.kotlin.analysis.api.types.KaSubstitutor

public abstract class KaSubstitutorProvider : KaSessionComponent() {
    public abstract fun createSubstitutor(
        subClass: KaClassOrObjectSymbol,
        superClass: KaClassOrObjectSymbol,
    ): KaSubstitutor?
}

public typealias KtSubstitutorProvider = KaSubstitutorProvider

public interface KaSubstitutorProviderMixIn : KaSessionMixIn {
    /**
     * Creates a [KaSubstitutor] based on the inheritance relationship between [subClass] and [superClass].
     *
     * The semantic of resulted [KaSubstitutor] is the substitutor that should be applied to a member of [superClass],
     * so it can be called on an instance of [subClass].
     *
     * Basically, it's a composition of inheritance-based substitutions for all the inheritance chain.
     *
     * On the following code:
     * ```
     * class A : B<String>
     * class B<T> : C<T, Int>
     * class C<X, Y>
     * ```
     *
     * * `createInheritanceTypeSubstitutor(A, B)` returns `KtSubstitutor {T -> String}`
     * * `createInheritanceTypeSubstitutor(B, C)` returns `KtSubstitutor {X -> T, Y -> Int}`
     * * `createInheritanceTypeSubstitutor(A, C)` returns `KtSubstitutor {X -> T, Y -> Int} andThen KtSubstitutor {T -> String}`
     *
     * @param subClass the subClass or object symbol.
     * @param superClass the super class symbol.
     * @return [KaSubstitutor] if [subClass] inherits [superClass] and there are no error types in the inheritance path. Returns `null` otherwise.
     */
    public fun createInheritanceTypeSubstitutor(
        subClass: KaClassOrObjectSymbol,
        superClass: KaClassOrObjectSymbol,
    ): KaSubstitutor? = withValidityAssertion {
        analysisSession.substitutorProvider.createSubstitutor(subClass, superClass)
    }
}

public typealias KtSubstitutorProviderMixIn = KaSubstitutorProviderMixIn