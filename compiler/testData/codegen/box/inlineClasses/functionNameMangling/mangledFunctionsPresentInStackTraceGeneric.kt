// TARGET_BACKEND: JVM
// ^^^ Throwable.stackTrace is available only in JDK
// FULL_JDK
// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +ValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value class Id<T: String>(val id: T)

fun throws() {
    throw RuntimeException()
}

fun test(id: Id<String>) {
    throws()
}

fun foo() {
    test(Id("id"))
}

fun box(): String {
    val stackTrace = try {
        foo()
        throw AssertionError()
    } catch (e: RuntimeException) {
        e.stackTrace
    }

    for (entry in stackTrace) {
        if (entry.methodName.startsWith("test")) {
            return "OK"
        }
    }

    throw AssertionError(stackTrace.asList().toString())
}