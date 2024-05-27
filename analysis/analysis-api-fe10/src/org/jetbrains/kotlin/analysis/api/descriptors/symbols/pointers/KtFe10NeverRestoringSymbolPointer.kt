/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.descriptors.symbols.pointers

import org.jetbrains.kotlin.analysis.api.KaSession
import org.jetbrains.kotlin.analysis.api.symbols.KaSymbol
import org.jetbrains.kotlin.analysis.api.symbols.pointers.KaSymbolPointer

internal class KaFe10NeverRestoringSymbolPointer<T : KaSymbol> : KaSymbolPointer<T>() {
    @Deprecated("Consider using org.jetbrains.kotlin.analysis.api.KaSession.restoreSymbol", ReplaceWith("null"))
    override fun restoreSymbol(analysisSession: KaSession): T? {
        return null
    }
}