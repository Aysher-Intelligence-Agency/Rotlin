/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.diagnostic;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/low-level-api-fir/testData/fileStructure")
@TestDataPath("$PROJECT_ROOT")
public class ScriptDiagnosticTraversalCounterTestGenerated extends AbstractScriptDiagnosticTraversalCounterTest {
  @Test
  public void testAllFilesPresentInFileStructure() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/fileStructure"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
  }

  @Test
  @TestMetadata("classMemberPropertyScript.kts")
  public void testClassMemberPropertyScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/classMemberPropertyScript.kts");
  }

  @Test
  @TestMetadata("classScript.kts")
  public void testClassScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/classScript.kts");
  }

  @Test
  @TestMetadata("constructorsScript.kts")
  public void testConstructorsScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/constructorsScript.kts");
  }

  @Test
  @TestMetadata("danglingAnnotationClassLevelScript.kts")
  public void testDanglingAnnotationClassLevelScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/danglingAnnotationClassLevelScript.kts");
  }

  @Test
  @TestMetadata("declarationsInPropertyInitScript.kts")
  public void testDeclarationsInPropertyInitScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/declarationsInPropertyInitScript.kts");
  }

  @Test
  @TestMetadata("destructuring.kts")
  public void testDestructuring() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/destructuring.kts");
  }

  @Test
  @TestMetadata("enumClassScript.kts")
  public void testEnumClassScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/enumClassScript.kts");
  }

  @Test
  @TestMetadata("enumClassWithBodyScript.kts")
  public void testEnumClassWithBodyScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/enumClassWithBodyScript.kts");
  }

  @Test
  @TestMetadata("functionWithImplicitTypeAndFunctionInsideLocalClassScript.kts")
  public void testFunctionWithImplicitTypeAndFunctionInsideLocalClassScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/functionWithImplicitTypeAndFunctionInsideLocalClassScript.kts");
  }

  @Test
  @TestMetadata("functionWithImplicitTypeAndFunctionInsideScript.kts")
  public void testFunctionWithImplicitTypeAndFunctionInsideScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/functionWithImplicitTypeAndFunctionInsideScript.kts");
  }

  @Test
  @TestMetadata("functionWithImplicitTypeAndPropertyInsideScript.kts")
  public void testFunctionWithImplicitTypeAndPropertyInsideScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/functionWithImplicitTypeAndPropertyInsideScript.kts");
  }

  @Test
  @TestMetadata("initBlockScript.kts")
  public void testInitBlockScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/initBlockScript.kts");
  }

  @Test
  @TestMetadata("localClassScript.kts")
  public void testLocalClassScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/localClassScript.kts");
  }

  @Test
  @TestMetadata("localFunScript.kts")
  public void testLocalFunScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/localFunScript.kts");
  }

  @Test
  @TestMetadata("localPropertyScript.kts")
  public void testLocalPropertyScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/localPropertyScript.kts");
  }

  @Test
  @TestMetadata("memberTypeAliasScript.kts")
  public void testMemberTypeAliasScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/memberTypeAliasScript.kts");
  }

  @Test
  @TestMetadata("nestedClassesScript.kts")
  public void testNestedClassesScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/nestedClassesScript.kts");
  }

  @Test
  @TestMetadata("propertyAccessorsScript.kts")
  public void testPropertyAccessorsScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/propertyAccessorsScript.kts");
  }

  @Test
  @TestMetadata("propertyWithImplicitTypeAndAnnotationsInsideLocalClassScript.kts")
  public void testPropertyWithImplicitTypeAndAnnotationsInsideLocalClassScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/propertyWithImplicitTypeAndAnnotationsInsideLocalClassScript.kts");
  }

  @Test
  @TestMetadata("propertyWithImplicitTypeAndFieldAnnotationsInsideLocalClassScript.kts")
  public void testPropertyWithImplicitTypeAndFieldAnnotationsInsideLocalClassScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/propertyWithImplicitTypeAndFieldAnnotationsInsideLocalClassScript.kts");
  }

  @Test
  @TestMetadata("script.kts")
  public void testScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/script.kts");
  }

  @Test
  @TestMetadata("secondLevelFunction.kts")
  public void testSecondLevelFunction() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/secondLevelFunction.kts");
  }

  @Test
  @TestMetadata("secondLevelFunction2.kts")
  public void testSecondLevelFunction2() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/secondLevelFunction2.kts");
  }

  @Test
  @TestMetadata("superClassCallScript.kts")
  public void testSuperClassCallScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/superClassCallScript.kts");
  }

  @Test
  @TestMetadata("topLevelExpressionBodyFunWithTypeScript.kts")
  public void testTopLevelExpressionBodyFunWithTypeScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/topLevelExpressionBodyFunWithTypeScript.kts");
  }

  @Test
  @TestMetadata("topLevelExpressionBodyFunWithoutTypeScript.kts")
  public void testTopLevelExpressionBodyFunWithoutTypeScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/topLevelExpressionBodyFunWithoutTypeScript.kts");
  }

  @Test
  @TestMetadata("topLevelFunWithTypeScript.kts")
  public void testTopLevelFunWithTypeScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/topLevelFunWithTypeScript.kts");
  }

  @Test
  @TestMetadata("topLevelPropertyScript.kts")
  public void testTopLevelPropertyScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/topLevelPropertyScript.kts");
  }

  @Test
  @TestMetadata("topLevelUnitFunScript.kts")
  public void testTopLevelUnitFunScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/topLevelUnitFunScript.kts");
  }

  @Test
  @TestMetadata("withoutNameScript.kts")
  public void testWithoutNameScript() {
    runTest("analysis/low-level-api-fir/testData/fileStructure/withoutNameScript.kts");
  }
}
