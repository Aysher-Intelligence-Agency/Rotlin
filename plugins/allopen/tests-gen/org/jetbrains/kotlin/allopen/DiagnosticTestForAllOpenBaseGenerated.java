/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.allopen;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/allopen/testData/diagnostics")
@TestDataPath("$PROJECT_ROOT")
public class DiagnosticTestForAllOpenBaseGenerated extends AbstractDiagnosticTestForAllOpenBase {
  @Test
  public void testAllFilesPresentInDiagnostics() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/allopen/testData/diagnostics"), Pattern.compile("^(.+)\\.kt$"), Pattern.compile("^(.+)\\.fir\\.kts?$"), true);
  }

  @Test
  @TestMetadata("allOpenOnAnnotation.kt")
  public void testAllOpenOnAnnotation() {
    runTest("plugins/allopen/testData/diagnostics/allOpenOnAnnotation.kt");
  }

  @Test
  @TestMetadata("kt54260.kt")
  public void testKt54260() {
    runTest("plugins/allopen/testData/diagnostics/kt54260.kt");
  }

  @Test
  @TestMetadata("kt60448.kt")
  public void testKt60448() {
    runTest("plugins/allopen/testData/diagnostics/kt60448.kt");
  }

  @Test
  @TestMetadata("redundantModality.kt")
  public void testRedundantModality() {
    runTest("plugins/allopen/testData/diagnostics/redundantModality.kt");
  }

  @Test
  @TestMetadata("smartcast.kt")
  public void testSmartcast() {
    runTest("plugins/allopen/testData/diagnostics/smartcast.kt");
  }
}
