// RENDER_DIAGNOSTICS_MESSAGES

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class Ann(val s: String = "")

@Ann("s")
fun foo() {}

val bar = foo(
    <!TOO_MANY_ARGUMENTS("@Ann(...) fun foo(): Unit")!>15<!>
)
