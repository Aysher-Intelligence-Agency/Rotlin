/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.build.report.metrics

import java.io.Serializable
import java.util.*

data class BuildAttributes(
    private val myAttributes: MutableMap<BuildAttribute, Int> = EnumMap(BuildAttribute::class.java)
) : Serializable {

    fun add(attr: BuildAttribute, count: Int = 1) {
        myAttributes[attr] = myAttributes.getOrDefault(attr, 0) + count
    }

    fun addAll(other: BuildAttributes) {
        other.myAttributes.forEach { (attr, n) -> add(attr, n) }
    }

    fun asMap(): Map<BuildAttribute, Int> = myAttributes

    companion object {
        const val serialVersionUID = 0L
    }
}