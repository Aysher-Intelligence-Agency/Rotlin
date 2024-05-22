/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.symbolDeclarationRenderer;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.symbolDeclarationRenderer.AbstractSymbolRenderingByReferenceTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/symbolDeclarationRenderer/symbolRenderingByReference")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleSymbolRenderingByReferenceTestGenerated extends AbstractSymbolRenderingByReferenceTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Ide
      )
    );
  }

  @Test
  public void testAllFilesPresentInSymbolRenderingByReference() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/symbolDeclarationRenderer/symbolRenderingByReference"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("javaEnhancedType.kt")
  public void testJavaEnhancedType() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/symbolRenderingByReference/javaEnhancedType.kt");
  }

  @Test
  @TestMetadata("javaEnhancedTypeExternalAnnotation.kt")
  public void testJavaEnhancedTypeExternalAnnotation() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/symbolRenderingByReference/javaEnhancedTypeExternalAnnotation.kt");
  }

  @Test
  @TestMetadata("javaMethodWithMultipleTypeParametersBound.kt")
  public void testJavaMethodWithMultipleTypeParametersBound() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/symbolRenderingByReference/javaMethodWithMultipleTypeParametersBound.kt");
  }

  @Test
  @TestMetadata("javaMethodWithTypeParametersBound.kt")
  public void testJavaMethodWithTypeParametersBound() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/symbolRenderingByReference/javaMethodWithTypeParametersBound.kt");
  }

  @Test
  @TestMetadata("jsrAnnotation.kt")
  public void testJsrAnnotation() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/symbolRenderingByReference/jsrAnnotation.kt");
  }

  @Test
  @TestMetadata("jsrAnnotationInsideLibrary.kt")
  public void testJsrAnnotationInsideLibrary() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/symbolRenderingByReference/jsrAnnotationInsideLibrary.kt");
  }
}
