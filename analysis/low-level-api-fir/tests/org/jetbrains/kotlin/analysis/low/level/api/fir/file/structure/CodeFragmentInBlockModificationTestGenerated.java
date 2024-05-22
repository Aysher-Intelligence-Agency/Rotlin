/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.file.structure;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/low-level-api-fir/testData/inBlockModification/codeFragments")
@TestDataPath("$PROJECT_ROOT")
public class CodeFragmentInBlockModificationTestGenerated extends AbstractCodeFragmentInBlockModificationTest {
  @Test
  public void testAllFilesPresentInCodeFragments() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/inBlockModification/codeFragments"), Pattern.compile("^([^.]+)\\.kt$"), null, false);
  }

  @Test
  @TestMetadata("localClass.kt")
  public void testLocalClass() {
    runTest("analysis/low-level-api-fir/testData/inBlockModification/codeFragments/localClass.kt");
  }

  @Test
  @TestMetadata("localFunction.kt")
  public void testLocalFunction() {
    runTest("analysis/low-level-api-fir/testData/inBlockModification/codeFragments/localFunction.kt");
  }

  @Test
  @TestMetadata("simple.kt")
  public void testSimple() {
    runTest("analysis/low-level-api-fir/testData/inBlockModification/codeFragments/simple.kt");
  }
}
