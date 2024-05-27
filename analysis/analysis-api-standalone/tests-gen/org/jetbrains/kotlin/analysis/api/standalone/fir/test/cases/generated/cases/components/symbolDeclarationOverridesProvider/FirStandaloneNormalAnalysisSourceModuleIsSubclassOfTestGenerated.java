/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.standalone.fir.test.cases.generated.cases.components.symbolDeclarationOverridesProvider;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.symbolDeclarationOverridesProvider.AbstractIsSubclassOfTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/symbolDeclarationOverridesProvider/isSubclassOf")
@TestDataPath("$PROJECT_ROOT")
public class FirStandaloneNormalAnalysisSourceModuleIsSubclassOfTestGenerated extends AbstractIsSubclassOfTest {
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
  public void testAllFilesPresentInIsSubclassOf() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/symbolDeclarationOverridesProvider/isSubclassOf"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("childClass.kt")
  public void testChildClass() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationOverridesProvider/isSubclassOf/childClass.kt");
  }

  @Test
  @TestMetadata("grandParentClass.kt")
  public void testGrandParentClass() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationOverridesProvider/isSubclassOf/grandParentClass.kt");
  }

  @Test
  @TestMetadata("localClasses.kt")
  public void testLocalClasses() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationOverridesProvider/isSubclassOf/localClasses.kt");
  }

  @Test
  @TestMetadata("parentClass.kt")
  public void testParentClass() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationOverridesProvider/isSubclassOf/parentClass.kt");
  }

  @Test
  @TestMetadata("sameClass.kt")
  public void testSameClass() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationOverridesProvider/isSubclassOf/sameClass.kt");
  }

  @Test
  @TestMetadata("unrelatedClass.kt")
  public void testUnrelatedClass() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationOverridesProvider/isSubclassOf/unrelatedClass.kt");
  }
}
