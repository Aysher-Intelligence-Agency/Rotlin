/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.internal.dsl

import org.gradle.api.NamedDomainObjectContainer
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformSourceSetConventions
import org.jetbrains.kotlin.gradle.dsl.KotlinSourceSetConvention
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.konan.target.DEPRECATED_TARGET_MESSAGE

internal object KotlinMultiplatformSourceSetConventionsImpl : KotlinMultiplatformSourceSetConventions {

    // region Common Source Set Accessors

    // DO NOT EDIT MANUALLY! Generated by org.jetbrains.kotlin.generators.gradle.dsl.MppSourceSetConventionsCodegenKt

    override val NamedDomainObjectContainer<KotlinSourceSet>.commonMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.commonTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.nativeMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.nativeTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.appleMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.appleTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.iosMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.iosTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.tvosMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.tvosTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.macosMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.macosTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.linuxMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.linuxTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.mingwMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.mingwTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeTest by KotlinSourceSetConvention

    // endregion

    // region Non-Native Source Set Accessors

    // DO NOT EDIT MANUALLY! Generated by org.jetbrains.kotlin.generators.gradle.dsl.MppSourceSetConventionsCodegenKt

    override val NamedDomainObjectContainer<KotlinSourceSet>.jsMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.jsTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.jvmMain by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.jvmTest by KotlinSourceSetConvention

    @ExperimentalWasmDsl
    override val NamedDomainObjectContainer<KotlinSourceSet>.wasmJsMain by KotlinSourceSetConvention

    @ExperimentalWasmDsl
    override val NamedDomainObjectContainer<KotlinSourceSet>.wasmJsTest by KotlinSourceSetConvention

    @ExperimentalWasmDsl
    override val NamedDomainObjectContainer<KotlinSourceSet>.wasmWasiMain by KotlinSourceSetConvention

    @ExperimentalWasmDsl
    override val NamedDomainObjectContainer<KotlinSourceSet>.wasmWasiTest by KotlinSourceSetConvention

    // endregion

    // region Native Source Set Accessors

    // DO NOT EDIT MANUALLY! Generated by org.jetbrains.kotlin.generators.gradle.dsl.MppSourceSetConventionsCodegenKt

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeArm32Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeArm32Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeX64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeX64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeX86Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidNativeX86Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.iosArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.iosArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.iosSimulatorArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.iosSimulatorArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.iosX64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.iosX64Test by KotlinSourceSetConvention

    @Deprecated(DEPRECATED_TARGET_MESSAGE, level = DeprecationLevel.WARNING)
    override val NamedDomainObjectContainer<KotlinSourceSet>.linuxArm32HfpMain by KotlinSourceSetConvention

    @Deprecated(DEPRECATED_TARGET_MESSAGE, level = DeprecationLevel.WARNING)
    override val NamedDomainObjectContainer<KotlinSourceSet>.linuxArm32HfpTest by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.linuxArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.linuxArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.linuxX64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.linuxX64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.macosArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.macosArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.macosX64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.macosX64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.mingwX64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.mingwX64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.tvosArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.tvosArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.tvosSimulatorArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.tvosSimulatorArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.tvosX64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.tvosX64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosArm32Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosArm32Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosDeviceArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosDeviceArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosSimulatorArm64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosSimulatorArm64Test by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosX64Main by KotlinSourceSetConvention

    override val NamedDomainObjectContainer<KotlinSourceSet>.watchosX64Test by KotlinSourceSetConvention

    // endregion

    override val NamedDomainObjectContainer<KotlinSourceSet>.androidMain by KotlinSourceSetConvention
    override val NamedDomainObjectContainer<KotlinSourceSet>.androidUnitTest by KotlinSourceSetConvention
    override val NamedDomainObjectContainer<KotlinSourceSet>.androidInstrumentedTest by KotlinSourceSetConvention
}