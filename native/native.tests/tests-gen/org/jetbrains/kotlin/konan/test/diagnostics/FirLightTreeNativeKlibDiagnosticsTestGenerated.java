/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.test.diagnostics;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.junit.jupiter.api.Tag;
import org.jetbrains.kotlin.konan.test.blackbox.support.group.FirPipeline;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
public class FirLightTreeNativeKlibDiagnosticsTestGenerated extends AbstractFirLightTreeNativeDiagnosticsWithBackendTestBase {
  @Nested
  @TestMetadata("compiler/testData/diagnostics/klibSerializationTests")
  @TestDataPath("$PROJECT_ROOT")
  @Tag("frontend-fir")
  @FirPipeline()
  @Tag("klib")
  public class KlibSerializationTests {
    @Test
    public void testAllFilesPresentInKlibSerializationTests() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/klibSerializationTests"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("signatureClashClasses.kt")
    public void testSignatureClashClasses() {
      runTest("compiler/testData/diagnostics/klibSerializationTests/signatureClashClasses.kt");
    }

    @Test
    @TestMetadata("signatureClashFunctions.kt")
    public void testSignatureClashFunctions() {
      runTest("compiler/testData/diagnostics/klibSerializationTests/signatureClashFunctions.kt");
    }

    @Test
    @TestMetadata("signatureClashVariables.kt")
    public void testSignatureClashVariables() {
      runTest("compiler/testData/diagnostics/klibSerializationTests/signatureClashVariables.kt");
    }

    @Test
    @TestMetadata("signatureClash_MPP.kt")
    public void testSignatureClash_MPP() {
      runTest("compiler/testData/diagnostics/klibSerializationTests/signatureClash_MPP.kt");
    }
  }

  @Nested
  @TestMetadata("compiler/testData/diagnostics/nativeTests/specialBackendChecks")
  @TestDataPath("$PROJECT_ROOT")
  @Tag("frontend-fir")
  @FirPipeline()
  @Tag("klib")
  public class SpecialBackendChecks {
    @Test
    public void testAllFilesPresentInSpecialBackendChecks() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests/specialBackendChecks"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Nested
    @TestMetadata("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop")
    @TestDataPath("$PROJECT_ROOT")
    @Tag("frontend-fir")
    @FirPipeline()
    @Tag("klib")
    public class CInterop {
      @Test
      public void testAllFilesPresentInCInterop() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("t1.kt")
      public void testT1() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t1.kt");
      }

      @Test
      @TestMetadata("t10.kt")
      public void testT10() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t10.kt");
      }

      @Test
      @TestMetadata("t11.kt")
      public void testT11() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t11.kt");
      }

      @Test
      @TestMetadata("t12.kt")
      public void testT12() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t12.kt");
      }

      @Test
      @TestMetadata("t13.kt")
      public void testT13() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t13.kt");
      }

      @Test
      @TestMetadata("t14.kt")
      public void testT14() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t14.kt");
      }

      @Test
      @TestMetadata("t37.kt")
      public void testT37() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t37.kt");
      }

      @Test
      @TestMetadata("t38.kt")
      public void testT38() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t38.kt");
      }

      @Test
      @TestMetadata("t40.kt")
      public void testT40() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t40.kt");
      }

      @Test
      @TestMetadata("t41.kt")
      public void testT41() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t41.kt");
      }

      @Test
      @TestMetadata("t42.kt")
      public void testT42() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t42.kt");
      }

      @Test
      @TestMetadata("t43.kt")
      public void testT43() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t43.kt");
      }

      @Test
      @TestMetadata("t44.kt")
      public void testT44() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t44.kt");
      }

      @Test
      @TestMetadata("t45.kt")
      public void testT45() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t45.kt");
      }

      @Test
      @TestMetadata("t46.kt")
      public void testT46() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t46.kt");
      }

      @Test
      @TestMetadata("t47.kt")
      public void testT47() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t47.kt");
      }

      @Test
      @TestMetadata("t60.kt")
      public void testT60() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t60.kt");
      }

      @Test
      @TestMetadata("t63.kt")
      public void testT63() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t63.kt");
      }

      @Test
      @TestMetadata("t64.kt")
      public void testT64() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t64.kt");
      }

      @Test
      @TestMetadata("t8.kt")
      public void testT8() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t8.kt");
      }

      @Test
      @TestMetadata("t9.kt")
      public void testT9() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/cInterop/t9.kt");
      }
    }

    @Nested
    @TestMetadata("compiler/testData/diagnostics/nativeTests/specialBackendChecks/concurrent")
    @TestDataPath("$PROJECT_ROOT")
    @Tag("frontend-fir")
    @FirPipeline()
    @Tag("klib")
    public class Concurrent {
      @Test
      public void testAllFilesPresentInConcurrent() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests/specialBackendChecks/concurrent"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("t48.kt")
      public void testT48() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/concurrent/t48.kt");
      }

      @Test
      @TestMetadata("t49.kt")
      public void testT49() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/concurrent/t49.kt");
      }

      @Test
      @TestMetadata("t50.kt")
      public void testT50() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/concurrent/t50.kt");
      }

      @Test
      @TestMetadata("t51.kt")
      public void testT51() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/concurrent/t51.kt");
      }
    }

    @Nested
    @TestMetadata("compiler/testData/diagnostics/nativeTests/specialBackendChecks/immutableBlobOf")
    @TestDataPath("$PROJECT_ROOT")
    @Tag("frontend-fir")
    @FirPipeline()
    @Tag("klib")
    public class ImmutableBlobOf {
      @Test
      public void testAllFilesPresentInImmutableBlobOf() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests/specialBackendChecks/immutableBlobOf"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("t54.kt")
      public void testT54() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/immutableBlobOf/t54.kt");
      }

      @Test
      @TestMetadata("t55.kt")
      public void testT55() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/immutableBlobOf/t55.kt");
      }

      @Test
      @TestMetadata("t56.kt")
      public void testT56() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/immutableBlobOf/t56.kt");
      }

      @Test
      @TestMetadata("t57.kt")
      public void testT57() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/immutableBlobOf/t57.kt");
      }
    }

    @Nested
    @TestMetadata("compiler/testData/diagnostics/nativeTests/specialBackendChecks/nativeRef")
    @TestDataPath("$PROJECT_ROOT")
    @Tag("frontend-fir")
    @FirPipeline()
    @Tag("klib")
    public class NativeRef {
      @Test
      public void testAllFilesPresentInNativeRef() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests/specialBackendChecks/nativeRef"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("t52.kt")
      public void testT52() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/nativeRef/t52.kt");
      }

      @Test
      @TestMetadata("t53.kt")
      public void testT53() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/nativeRef/t53.kt");
      }
    }

    @Nested
    @TestMetadata("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop")
    @TestDataPath("$PROJECT_ROOT")
    @Tag("frontend-fir")
    @FirPipeline()
    @Tag("klib")
    public class ObjCInterop {
      @Test
      public void testAllFilesPresentInObjCInterop() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("t15.kt")
      public void testT15() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t15.kt");
      }

      @Test
      @TestMetadata("t16.kt")
      public void testT16() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t16.kt");
      }

      @Test
      @TestMetadata("t17.kt")
      public void testT17() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t17.kt");
      }

      @Test
      @TestMetadata("t18.kt")
      public void testT18() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t18.kt");
      }

      @Test
      @TestMetadata("t2.kt")
      public void testT2() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t2.kt");
      }

      @Test
      @TestMetadata("t20.kt")
      public void testT20() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t20.kt");
      }

      @Test
      @TestMetadata("t21.kt")
      public void testT21() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t21.kt");
      }

      @Test
      @TestMetadata("t22.kt")
      public void testT22() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t22.kt");
      }

      @Test
      @TestMetadata("t23.kt")
      public void testT23() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t23.kt");
      }

      @Test
      @TestMetadata("t24.kt")
      public void testT24() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t24.kt");
      }

      @Test
      @TestMetadata("t25.kt")
      public void testT25() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t25.kt");
      }

      @Test
      @TestMetadata("t26.kt")
      public void testT26() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t26.kt");
      }

      @Test
      @TestMetadata("t27.kt")
      public void testT27() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t27.kt");
      }

      @Test
      @TestMetadata("t28.kt")
      public void testT28() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t28.kt");
      }

      @Test
      @TestMetadata("t29.kt")
      public void testT29() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t29.kt");
      }

      @Test
      @TestMetadata("t30.kt")
      public void testT30() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t30.kt");
      }

      @Test
      @TestMetadata("t31.kt")
      public void testT31() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t31.kt");
      }

      @Test
      @TestMetadata("t32.kt")
      public void testT32() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t32.kt");
      }

      @Test
      @TestMetadata("t33.kt")
      public void testT33() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t33.kt");
      }

      @Test
      @TestMetadata("t34.kt")
      public void testT34() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t34.kt");
      }

      @Test
      @TestMetadata("t35.kt")
      public void testT35() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t35.kt");
      }

      @Test
      @TestMetadata("t4.kt")
      public void testT4() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t4.kt");
      }

      @Test
      @TestMetadata("t5.kt")
      public void testT5() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t5.kt");
      }

      @Test
      @TestMetadata("t6.kt")
      public void testT6() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t6.kt");
      }

      @Test
      @TestMetadata("t61.kt")
      public void testT61() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t61.kt");
      }

      @Test
      @TestMetadata("t62.kt")
      public void testT62() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t62.kt");
      }

      @Test
      @TestMetadata("t7.kt")
      public void testT7() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/objCInterop/t7.kt");
      }
    }

    @Nested
    @TestMetadata("compiler/testData/diagnostics/nativeTests/specialBackendChecks/posix")
    @TestDataPath("$PROJECT_ROOT")
    @Tag("frontend-fir")
    @FirPipeline()
    @Tag("klib")
    public class Posix {
      @Test
      public void testAllFilesPresentInPosix() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests/specialBackendChecks/posix"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("t3.kt")
      public void testT3() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/posix/t3.kt");
      }

      @Test
      @TestMetadata("t36.kt")
      public void testT36() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/posix/t36.kt");
      }
    }

    @Nested
    @TestMetadata("compiler/testData/diagnostics/nativeTests/specialBackendChecks/reflect")
    @TestDataPath("$PROJECT_ROOT")
    @Tag("frontend-fir")
    @FirPipeline()
    @Tag("klib")
    public class Reflect {
      @Test
      public void testAllFilesPresentInReflect() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests/specialBackendChecks/reflect"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("t58.kt")
      public void testT58() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/reflect/t58.kt");
      }

      @Test
      @TestMetadata("t59.kt")
      public void testT59() {
        runTest("compiler/testData/diagnostics/nativeTests/specialBackendChecks/reflect/t59.kt");
      }
    }
  }
}
