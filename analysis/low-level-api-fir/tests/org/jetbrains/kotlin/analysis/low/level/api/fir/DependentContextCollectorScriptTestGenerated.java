/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/low-level-api-fir/testData/contextCollector")
@TestDataPath("$PROJECT_ROOT")
public class DependentContextCollectorScriptTestGenerated extends AbstractDependentContextCollectorScriptTest {
  @Test
  public void testAllFilesPresentInContextCollector() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/contextCollector"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/contextCollector/classHeaderPositions")
  @TestDataPath("$PROJECT_ROOT")
  public class ClassHeaderPositions {
    @Test
    public void testAllFilesPresentInClassHeaderPositions() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/contextCollector/classHeaderPositions"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/contextCollector/error")
  @TestDataPath("$PROJECT_ROOT")
  public class Error {
    @Test
    public void testAllFilesPresentInError() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/contextCollector/error"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/contextCollector/scripts")
  @TestDataPath("$PROJECT_ROOT")
  public class Scripts {
    @Test
    public void testAllFilesPresentInScripts() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/contextCollector/scripts"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @Test
    @TestMetadata("insideClassBody.kts")
    public void testInsideClassBody() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/insideClassBody.kts");
    }

    @Test
    @TestMetadata("insideClassMember.kts")
    public void testInsideClassMember() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/insideClassMember.kts");
    }

    @Test
    @TestMetadata("insideTopLevelFunction.kts")
    public void testInsideTopLevelFunction() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/insideTopLevelFunction.kts");
    }

    @Test
    @TestMetadata("lastStatement.kts")
    public void testLastStatement() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/lastStatement.kts");
    }

    @Test
    @TestMetadata("scriptInsideLastStatement.kts")
    public void testScriptInsideLastStatement() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/scriptInsideLastStatement.kts");
    }

    @Test
    @TestMetadata("statement.kts")
    public void testStatement() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/statement.kts");
    }

    @Test
    @TestMetadata("topLevel.kts")
    public void testTopLevel() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/topLevel.kts");
    }

    @Test
    @TestMetadata("topLevelDestructuring_after.kts")
    public void testTopLevelDestructuring_after() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/topLevelDestructuring_after.kts");
    }

    @Test
    @TestMetadata("topLevelDestructuring_initializer.kts")
    public void testTopLevelDestructuring_initializer() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/topLevelDestructuring_initializer.kts");
    }

    @Test
    @TestMetadata("topLevelDestructuring_subProperty.kts")
    public void testTopLevelDestructuring_subProperty() {
      runTest("analysis/low-level-api-fir/testData/contextCollector/scripts/topLevelDestructuring_subProperty.kts");
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/contextCollector/smartCasts")
  @TestDataPath("$PROJECT_ROOT")
  public class SmartCasts {
    @Test
    public void testAllFilesPresentInSmartCasts() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/contextCollector/smartCasts"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/contextCollector/typeParameters")
  @TestDataPath("$PROJECT_ROOT")
  public class TypeParameters {
    @Test
    public void testAllFilesPresentInTypeParameters() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/contextCollector/typeParameters"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }
  }

  @Nested
  @TestMetadata("analysis/low-level-api-fir/testData/contextCollector/withTestCompilerPluginEnabled")
  @TestDataPath("$PROJECT_ROOT")
  public class WithTestCompilerPluginEnabled {
    @Test
    public void testAllFilesPresentInWithTestCompilerPluginEnabled() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testData/contextCollector/withTestCompilerPluginEnabled"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }
  }
}
