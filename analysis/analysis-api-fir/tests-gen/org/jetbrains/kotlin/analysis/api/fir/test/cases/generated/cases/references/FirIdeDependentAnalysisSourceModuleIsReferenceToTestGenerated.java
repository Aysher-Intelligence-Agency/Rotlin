/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.references;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.references.AbstractIsReferenceToTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/references/isReferenceTo")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeDependentAnalysisSourceModuleIsReferenceToTestGenerated extends AbstractIsReferenceToTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Dependent,
        AnalysisApiMode.Ide
      )
    );
  }

  @Test
  public void testAllFilesPresentInIsReferenceTo() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/references/isReferenceTo"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("getterCall.kt")
  public void testGetterCall() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/getterCall.kt");
  }

  @Test
  @TestMetadata("getterReference.kt")
  public void testGetterReference() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/getterReference.kt");
  }

  @Test
  @TestMetadata("instanceMethodCall.kt")
  public void testInstanceMethodCall() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/instanceMethodCall.kt");
  }

  @Test
  @TestMetadata("javaGetterCall.kt")
  public void testJavaGetterCall() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/javaGetterCall.kt");
  }

  @Test
  @TestMetadata("javaGetterReference.kt")
  public void testJavaGetterReference() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/javaGetterReference.kt");
  }

  @Test
  @TestMetadata("javaInstanceMethodCall.kt")
  public void testJavaInstanceMethodCall() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/javaInstanceMethodCall.kt");
  }

  @Test
  @TestMetadata("javaSetterCall.kt")
  public void testJavaSetterCall() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/javaSetterCall.kt");
  }

  @Test
  @TestMetadata("javaStaticMethodCallReceiverReference.kt")
  public void testJavaStaticMethodCallReceiverReference() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/javaStaticMethodCallReceiverReference.kt");
  }

  @Test
  @TestMetadata("javaStaticMethodCallSelectorReference.kt")
  public void testJavaStaticMethodCallSelectorReference() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/javaStaticMethodCallSelectorReference.kt");
  }

  @Test
  @TestMetadata("setterCall.kt")
  public void testSetterCall() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/setterCall.kt");
  }

  @Test
  @TestMetadata("topLevelFunctionCall.kt")
  public void testTopLevelFunctionCall() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/topLevelFunctionCall.kt");
  }

  @Test
  @TestMetadata("topLevelInfixFunctionCall.kt")
  public void testTopLevelInfixFunctionCall() {
    runTest("analysis/analysis-api/testData/references/isReferenceTo/topLevelInfixFunctionCall.kt");
  }
}
