// DIAGNOSTICS: -UNUSED_PARAMETER

class Scope

fun <T> simpleAsync0(block: Scope.() -> T) {}
fun <T> simpleAsync1(block: suspend Scope.() -> T) {}
suspend fun <T> simpleAsync2(block: Scope.() -> T) {}
suspend fun <T> simpleAsync3(block: suspend Scope.() -> T) {}

fun insideJob0() = doTheJob0()
fun insideJob1() = doTheJob1()
suspend fun insideJob2() = doTheJob2()
suspend fun insideJob3() = doTheJob3()

fun doTheJob0() = <!CANNOT_INFER_PARAMETER_TYPE!>simpleAsync0<!> <!CANNOT_INFER_PARAMETER_TYPE!>{ <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>insideJob0()<!> }<!>
fun doTheJob1() = <!CANNOT_INFER_PARAMETER_TYPE!>simpleAsync1<!> <!CANNOT_INFER_PARAMETER_TYPE!>{ <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>insideJob1()<!> }<!>
suspend fun doTheJob2() = <!CANNOT_INFER_PARAMETER_TYPE!>simpleAsync2<!> <!CANNOT_INFER_PARAMETER_TYPE!>{ <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!><!NON_LOCAL_SUSPENSION_POINT!>insideJob2<!>()<!> }<!>
suspend fun doTheJob3() = <!CANNOT_INFER_PARAMETER_TYPE!>simpleAsync3<!> <!CANNOT_INFER_PARAMETER_TYPE!>{ <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>insideJob3()<!> }<!>
