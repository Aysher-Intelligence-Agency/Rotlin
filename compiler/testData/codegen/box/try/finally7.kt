/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */
// JVM_ABI_K1_K2_DIFF: KT-63864
// WITH_STDLIB

import kotlin.test.*

val sb = StringBuilder()

fun box(): String {
    sb.appendLine(foo())
    assertEquals("""
        Done
        Finally
        1

    """.trimIndent(), sb.toString())
    return "OK"
}

fun foo(): Int {
    try {
        sb.appendLine("Done")
        throw Error()
    } finally {
        sb.appendLine("Finally")
        return 1
    }

    sb.appendLine("After")
    return 2
}