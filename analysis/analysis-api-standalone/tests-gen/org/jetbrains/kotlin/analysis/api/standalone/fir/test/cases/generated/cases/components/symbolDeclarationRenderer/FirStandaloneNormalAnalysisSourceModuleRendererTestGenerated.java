/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.standalone.fir.test.cases.generated.cases.components.symbolDeclarationRenderer;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.symbolDeclarationRenderer.AbstractRendererTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration")
@TestDataPath("$PROJECT_ROOT")
public class FirStandaloneNormalAnalysisSourceModuleRendererTestGenerated extends AbstractRendererTest {
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
  @TestMetadata("actualInheritance.kt")
  public void testActualInheritance() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/actualInheritance.kt");
  }

  @Test
  public void testAllFilesPresentInRenderDeclaration() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("annotation.kt")
  public void testAnnotation() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/annotation.kt");
  }

  @Test
  @TestMetadata("complexTypes.kt")
  public void testComplexTypes() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/complexTypes.kt");
  }

  @Test
  @TestMetadata("constructorInObject.kt")
  public void testConstructorInObject() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/constructorInObject.kt");
  }

  @Test
  @TestMetadata("constructorOfAnonymousObject.kt")
  public void testConstructorOfAnonymousObject() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/constructorOfAnonymousObject.kt");
  }

  @Test
  @TestMetadata("contextReceiver.kt")
  public void testContextReceiver() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/contextReceiver.kt");
  }

  @Test
  @TestMetadata("delegates.kt")
  public void testDelegates() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/delegates.kt");
  }

  @Test
  @TestMetadata("derivedClass.kt")
  public void testDerivedClass() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/derivedClass.kt");
  }

  @Test
  @TestMetadata("emptyAnonymousObject.kt")
  public void testEmptyAnonymousObject() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/emptyAnonymousObject.kt");
  }

  @Test
  @TestMetadata("enums.kt")
  public void testEnums() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/enums.kt");
  }

  @Test
  @TestMetadata("enums2.kt")
  public void testEnums2() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/enums2.kt");
  }

  @Test
  @TestMetadata("expectActual.kt")
  public void testExpectActual() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/expectActual.kt");
  }

  @Test
  @TestMetadata("F.kt")
  public void testF() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/F.kt");
  }

  @Test
  @TestMetadata("functionTypes.kt")
  public void testFunctionTypes() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/functionTypes.kt");
  }

  @Test
  @TestMetadata("functionalTypeAliases.kt")
  public void testFunctionalTypeAliases() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/functionalTypeAliases.kt");
  }

  @Test
  @TestMetadata("genericFunctions.kt")
  public void testGenericFunctions() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/genericFunctions.kt");
  }

  @Test
  @TestMetadata("genericProperty.kt")
  public void testGenericProperty() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/genericProperty.kt");
  }

  @Test
  @TestMetadata("intersectionType.kt")
  public void testIntersectionType() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/intersectionType.kt");
  }

  @Test
  @TestMetadata("nestedClass.kt")
  public void testNestedClass() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/nestedClass.kt");
  }

  @Test
  @TestMetadata("NestedOfAliasedType.kt")
  public void testNestedOfAliasedType() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/NestedOfAliasedType.kt");
  }

  @Test
  @TestMetadata("NestedSuperType.kt")
  public void testNestedSuperType() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/NestedSuperType.kt");
  }

  @Test
  @TestMetadata("noPrimaryConstructor.kt")
  public void testNoPrimaryConstructor() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/noPrimaryConstructor.kt");
  }

  @Test
  @TestMetadata("simpleClass.kt")
  public void testSimpleClass() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/simpleClass.kt");
  }

  @Test
  @TestMetadata("simpleFun.kt")
  public void testSimpleFun() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/simpleFun.kt");
  }

  @Test
  @TestMetadata("simpleTypeAlias.kt")
  public void testSimpleTypeAlias() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/simpleTypeAlias.kt");
  }

  @Test
  @TestMetadata("typeAliasWithGeneric.kt")
  public void testTypeAliasWithGeneric() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/typeAliasWithGeneric.kt");
  }

  @Test
  @TestMetadata("typeParameterVsNested.kt")
  public void testTypeParameterVsNested() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/typeParameterVsNested.kt");
  }

  @Test
  @TestMetadata("typeParameters.kt")
  public void testTypeParameters() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/typeParameters.kt");
  }

  @Test
  @TestMetadata("vararg.kt")
  public void testVararg() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/vararg.kt");
  }

  @Test
  @TestMetadata("where.kt")
  public void testWhere() {
    runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/where.kt");
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/types")
  @TestDataPath("$PROJECT_ROOT")
  public class Types {
    @Test
    public void testAllFilesPresentInTypes() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/types"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("annotationOnTypes.kt")
    public void testAnnotationOnTypes() {
      runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/types/annotationOnTypes.kt");
    }

    @Test
    @TestMetadata("annotationOnTypesWithComplexExpression.kt")
    public void testAnnotationOnTypesWithComplexExpression() {
      runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/types/annotationOnTypesWithComplexExpression.kt");
    }

    @Test
    @TestMetadata("approximatedCapturedType.kt")
    public void testApproximatedCapturedType() {
      runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/types/approximatedCapturedType.kt");
    }

    @Test
    @TestMetadata("contextFunctionTypes.kt")
    public void testContextFunctionTypes() {
      runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/types/contextFunctionTypes.kt");
    }

    @Test
    @TestMetadata("extraTypeArguments.kt")
    public void testExtraTypeArguments() {
      runTest("analysis/analysis-api/testData/components/symbolDeclarationRenderer/renderDeclaration/types/extraTypeArguments.kt");
    }
  }
}
