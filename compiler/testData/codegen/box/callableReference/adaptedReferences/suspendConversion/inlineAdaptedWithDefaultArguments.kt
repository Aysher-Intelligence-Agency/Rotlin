// LANGUAGE: +SuspendConversion
// WITH_STDLIB
// WITH_COROUTINES

import helpers.*
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*

fun runSuspend(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

fun foo(s1: String, s2: String = "K"): String = s1 + s2

inline suspend fun invokeSuspend(fn: suspend (String) -> String, arg: String) = fn.invoke(arg)

fun box(): String {
    var test = "failed"
    runSuspend {
        test = invokeSuspend(::foo, "O")
    }
    return test
}