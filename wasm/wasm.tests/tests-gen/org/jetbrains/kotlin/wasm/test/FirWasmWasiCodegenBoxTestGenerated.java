/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.wasm.test;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateWasmTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/boxWasmWasi")
@TestDataPath("$PROJECT_ROOT")
public class FirWasmWasiCodegenBoxTestGenerated extends AbstractFirWasmWasiCodegenBoxTest {
  @Test
  public void testAllFilesPresentInBoxWasmWasi() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxWasmWasi"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.WASM, true);
  }

  @Test
  @TestMetadata("onExportedFunctionExit.kt")
  public void testOnExportedFunctionExit() {
    runTest("compiler/testData/codegen/boxWasmWasi/onExportedFunctionExit.kt");
  }

  @Test
  @TestMetadata("simpleWasi.kt")
  public void testSimpleWasi() {
    runTest("compiler/testData/codegen/boxWasmWasi/simpleWasi.kt");
  }
}
