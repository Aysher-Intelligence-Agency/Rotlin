/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.standalone.fir.test.cases.generated.cases.references;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.standalone.fir.test.configurators.AnalysisApiFirStandaloneModeTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.references.AbstractReferenceImportAliasTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/imports/importAliases")
@TestDataPath("$PROJECT_ROOT")
public class FirStandaloneNormalAnalysisSourceModuleReferenceImportAliasTestGenerated extends AbstractReferenceImportAliasTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirStandaloneModeTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Standalone
      )
    );
  }

  @Test
  public void testAllFilesPresentInImportAliases() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/imports/importAliases"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("classAlias.kt")
  public void testClassAlias() {
    runTest("analysis/analysis-api/testData/imports/importAliases/classAlias.kt");
  }

  @Test
  @TestMetadata("classAliasWithCompanionObject.kt")
  public void testClassAliasWithCompanionObject() {
    runTest("analysis/analysis-api/testData/imports/importAliases/classAliasWithCompanionObject.kt");
  }

  @Test
  @TestMetadata("constructorAlias.kt")
  public void testConstructorAlias() {
    runTest("analysis/analysis-api/testData/imports/importAliases/constructorAlias.kt");
  }

  @Test
  @TestMetadata("functionAlias.kt")
  public void testFunctionAlias() {
    runTest("analysis/analysis-api/testData/imports/importAliases/functionAlias.kt");
  }

  @Test
  @TestMetadata("kdocReferenceAlias.kt")
  public void testKdocReferenceAlias() {
    runTest("analysis/analysis-api/testData/imports/importAliases/kdocReferenceAlias.kt");
  }

  @Test
  @TestMetadata("propertyAlias.kt")
  public void testPropertyAlias() {
    runTest("analysis/analysis-api/testData/imports/importAliases/propertyAlias.kt");
  }
}
