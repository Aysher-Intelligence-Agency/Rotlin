/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.standalone.fir.test.cases.generated.cases.components.substitutorProvider;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.substitutorProvider.AbstractCreateInheritanceTypeSubstitutorTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor")
@TestDataPath("$PROJECT_ROOT")
public class FirStandaloneNormalAnalysisSourceModuleCreateInheritanceTypeSubstitutorTestGenerated extends AbstractCreateInheritanceTypeSubstitutorTest {
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
  public void testAllFilesPresentInCreateInheritanceTypeSubstitutor() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("chain.kt")
  public void testChain() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/chain.kt");
  }

  @Test
  @TestMetadata("cycle.kt")
  public void testCycle() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/cycle.kt");
  }

  @Test
  @TestMetadata("diamond.kt")
  public void testDiamond() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/diamond.kt");
  }

  @Test
  @TestMetadata("directComplexSubstitution.kt")
  public void testDirectComplexSubstitution() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/directComplexSubstitution.kt");
  }

  @Test
  @TestMetadata("directType.kt")
  public void testDirectType() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/directType.kt");
  }

  @Test
  @TestMetadata("directTypeParam.kt")
  public void testDirectTypeParam() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/directTypeParam.kt");
  }

  @Test
  @TestMetadata("errorInUpperBound.kt")
  public void testErrorInUpperBound() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/errorInUpperBound.kt");
  }

  @Test
  @TestMetadata("extraTypeArgument.kt")
  public void testExtraTypeArgument() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/extraTypeArgument.kt");
  }

  @Test
  @TestMetadata("missingTypeArgument.kt")
  public void testMissingTypeArgument() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/missingTypeArgument.kt");
  }

  @Test
  @TestMetadata("multipleInheritance.kt")
  public void testMultipleInheritance() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/multipleInheritance.kt");
  }

  @Test
  @TestMetadata("self.kt")
  public void testSelf() {
    runTest("analysis/analysis-api/testData/components/substitutorProvider/createInheritanceTypeSubstitutor/self.kt");
  }
}
