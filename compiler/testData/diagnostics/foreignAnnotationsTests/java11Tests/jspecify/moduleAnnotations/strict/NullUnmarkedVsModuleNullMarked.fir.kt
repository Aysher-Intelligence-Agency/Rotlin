// ALLOW_KOTLIN_PACKAGE
// JSPECIFY_STATE: strict
// DIAGNOSTICS: -UNUSED_PARAMETER

// FILE: null_marked_module/module-info.java

import org.jspecify.annotations.*;

@NullMarked
module null_marked_module {
    requires java9_annotations;
    exports nullunmarkedpackage;
    exports unannotatedpackage;
}

// FILE: null_marked_module/nullunmarkedpackage/package-info.java

@NullUnmarked
package nullunmarkedpackage;

import org.jspecify.annotations.*;

// FILE: null_marked_module/nullunmarkedpackage/UnannotatedType.java

package nullunmarkedpackage;

public interface UnannotatedType {
    public String unannotatedProduce();
    public void unannotatedConsume(String arg);
}

// FILE: null_marked_module/unannotatedpackage/NullUnmarkedType.java

package unannotatedpackage;

import org.jspecify.annotations.*;

@NullUnmarked
public interface NullUnmarkedType {
    public String unannotatedProduce();
    public void unannotatedConsume(String arg);
}

// FILE: null_marked_module/unannotatedpackage/UnannotatedType.java

package unannotatedpackage;

import org.jspecify.annotations.*;

public interface UnannotatedType {
    @NullUnmarked
    public String nullUnmarkedProduce();
    @NullUnmarked
    public void nullUnmarkedConsume(String arg);
}

// FILE: null_marked_module/unannotatedpackage/UnannotatedTypeWithNullUnmarkedConstructor.java

package unannotatedpackage;

import org.jspecify.annotations.*;

public class UnannotatedTypeWithNullUnmarkedConstructor {
    @NullUnmarked
    public UnannotatedTypeWithNullUnmarkedConstructor(String arg) {}
}

// FILE: kotlin.kt

interface TestA: nullunmarkedpackage.UnannotatedType {
    override fun unannotatedProduce(): String?
}

interface TestB: unannotatedpackage.NullUnmarkedType {
    override fun unannotatedProduce(): String?
}

interface TestC: unannotatedpackage.UnannotatedType {
    override fun nullUnmarkedProduce(): String?
}

fun test(
    a: nullunmarkedpackage.UnannotatedType,
    b: unannotatedpackage.NullUnmarkedType,
    c: unannotatedpackage.UnannotatedType
) {
    a.unannotatedConsume(null)
    b.unannotatedConsume(null)
    c.nullUnmarkedConsume(null)
    unannotatedpackage.UnannotatedTypeWithNullUnmarkedConstructor(null)
}
