// DIAGNOSTICS: -UNUSED_EXPRESSION
// SKIP_TXT

/*
 * KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)
 *
 * SECTIONS: dfa
 * NUMBER: 5
 * DESCRIPTION: Raw data flow analysis test
 * HELPERS: classes, interfaces, properties, functions
 */

// TESTCASE NUMBER: 1
fun case_1(x: Any?) {
    if (x is Number?) {
        if (x !== null) {
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Number")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.propT
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Number")!>x<!>.propNullableAny
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
            <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Number")!>x<!>.funNullableAny()
        }
    }
}

// TESTCASE NUMBER: 2
fun case_2(x: Any?) {
    if (x is Number? && x is Int? && x != null) {
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.propT
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>.propNullableAny
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
        <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>.funNullableAny()
    }
}

// TESTCASE NUMBER: 3
fun case_3(x: Any?) {
    if (x is Number?) {
        if (x !== null) {
            if (x is Int?) {
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.propT
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>.propNullableAny
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>.funNullableAny()
            }
        }
    }
}

// TESTCASE NUMBER: 4
fun case_4(x: Any?) {
    if (x != null) {
        if (x is Number) {
            if (x is Int?) {
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.propT
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>.propNullableAny
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Number"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any? & kotlin.Int"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
                <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number")!>x<!>.funNullableAny()
            }
        }
    }
}

// TESTCASE NUMBER: 5
fun case_5(x: Any?) {
    if (x is ClassLevel1?) {
        if (x is ClassLevel2?) {
            if (x is ClassLevel3?) {
                if (x is ClassLevel4?) {
                    if (x is ClassLevel5?) {
                        if (x != null) {
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propT
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.propNullableAny
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.funNullableAny()
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
                            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
                        }
                    }
                }
            }
        }
    }
}

// TESTCASE NUMBER: 6
fun case_6(x: Any?) {
    if (x is ClassLevel1?) {
        if (x is ClassLevel2?) {
            if (x is ClassLevel3?) {
                if (x != null && x is ClassLevel4?) {
                    if (x is ClassLevel5?) {
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propT
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.propNullableAny
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.funNullableAny()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
                    }
                }
            }
        }
    }
}

// TESTCASE NUMBER: 7
fun case_7(x: Any?) {
    if (x is ClassLevel1? && x is ClassLevel2? && x is ClassLevel3?) {
        if (x is ClassLevel4? && x != null && x is ClassLevel5?) {
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propT
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.propNullableAny
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.funNullableAny()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
        }
    }
}

// TESTCASE NUMBER: 8
fun case_8(x: Any?) {
    if (x is ClassLevel1? && x is ClassLevel2? && x is ClassLevel3?) {
        if (x is ClassLevel4? && x != null && x is ClassLevel5?) {
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propT
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.propNullableAny
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.funNullableAny()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
        }
    }
}

// TESTCASE NUMBER: 9
fun case_9(x: Any?) {
    if (x is ClassLevel1? && x is ClassLevel2? && x is ClassLevel3? && x is ClassLevel4? && x != null && x is ClassLevel5?) {
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propT
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.propNullableAny
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.funNullableAny()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
    }
}

// TESTCASE NUMBER: 10
fun case_10(x: Any?) {
    if (x is ClassLevel1? && x is ClassLevel2? && x is ClassLevel3?) {
        if (x is ClassLevel4?) {

        } else if (x is ClassLevel5? && x != null) {
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propT
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.propNullableAny
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & ClassLevel3 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.funNullableAny()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
            <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
        }
    } else if (x is ClassLevel4? && x != null && x is ClassLevel5?) {
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.equals(null)
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propT
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propAny
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.propNullableT
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.propNullableAny
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funT()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funAny()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.funNullableT()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & ClassLevel5 & kotlin.Any & kotlin.Any?")!>x<!>.funNullableAny()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test3()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel4 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test4()
        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel5 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test5()
    }
}

/*
 * TESTCASE NUMBER: 11
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_11(x: Any?) {
    if (x is Interface1?) {
        if (x is Interface2?) {
            if (x != null) {
                <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & Interface2 & kotlin.Any & kotlin.Any?")!>x<!>
                <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
                <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()

                <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.let { <!DEBUG_INFO_EXPRESSION_TYPE("{Any & Interface1 & Interface2}")!>it<!>.itest1(); <!DEBUG_INFO_EXPRESSION_TYPE("{Any & Interface1 & Interface2}")!>it<!>.itest2() }
            }
        }
    }
}

/*
 * TESTCASE NUMBER: 12
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_12(x: Any?) {
    if (x is Interface1? && x != null && x is Interface2?) {
        <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & Interface2 & kotlin.Any & kotlin.Any?")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
        <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()

        <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.let { <!DEBUG_INFO_EXPRESSION_TYPE("{Any & Interface1 & Interface2}")!>it<!>.itest1(); <!DEBUG_INFO_EXPRESSION_TYPE("{Any & Interface1 & Interface2}")!>it<!>.itest2() }
    }
}

/*
 * TESTCASE NUMBER: 13
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_13(x: Any?) {
    if (x is Interface2?) {
        if (x is ClassLevel1?) {
            if (x is ClassLevel2? && x is Interface1?) {
                if (x !is Interface3?) {} else if (false) {
                    if (x != null) {
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & Interface1 & Interface2 & Interface3 & kotlin.Any & kotlin.Any?")!>x<!>
                        <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()
                        <!DEBUG_INFO_EXPRESSION_TYPE("Interface3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest3()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
                    }
                }
            }
        }
    }
}

/*
 * TESTCASE NUMBER: 14
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_14(x: Any?) {
    if (x is Interface2?) {
        if (x is ClassLevel1?) {
            if (x == null || x !is Interface1?) else {
                if (x is ClassLevel2?) {
                    if (x is Interface3?) {
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & Interface1 & Interface2 & Interface3 & kotlin.Any & kotlin.Any?")!>x<!>
                        <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()
                        <!DEBUG_INFO_EXPRESSION_TYPE("Interface3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest3()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                        <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
                    }
                }
            }
        }
    }
}

/*
 * TESTCASE NUMBER: 15
 * NOTE: lazy smartcasts
 * DISCUSSION
 * ISSUES: KT-28362
 */
fun case_15(x: Any?) {
    if (x !is ClassLevel2? || <!USELESS_IS_CHECK!>x !is ClassLevel1?<!>) else {
        if (x === null || x !is Interface1?) else {
            if (x !is Interface2? || x !is Interface3?) {} else {
                <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel1 & ClassLevel2 & Interface1 & Interface2 & Interface3 & kotlin.Any & kotlin.Any?")!>x<!>
                <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest2()
                <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest1()
                <!DEBUG_INFO_EXPRESSION_TYPE("Interface3 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.itest3()
                <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test1()
                <!DEBUG_INFO_EXPRESSION_TYPE("ClassLevel2 & kotlin.Any?"), DEBUG_INFO_SMARTCAST!>x<!>.test2()
            }
        }
    }
}

// TESTCASE NUMBER: 16
fun case_16(a: Any?, b: Int = if (a is Number? && a is Int? && a !== null) <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number"), DEBUG_INFO_SMARTCAST!>a<!> else 0) {
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any?")!>a<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.equals(null)
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.propT
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.propAny
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.propNullableT
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.propNullableAny
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.funT()
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.funAny()
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.funNullableT()
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.funNullableAny()
}

// TESTCASE NUMBER: 17
fun case_17(a: Any?, b: Int = if (a !is Number? || a !is Int? || a == null) 0 else <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any & kotlin.Any? & kotlin.Int & kotlin.Number"), DEBUG_INFO_SMARTCAST!>a<!>) {
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Any?")!>a<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.equals(null)
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.propT
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.propAny
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.propNullableT
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.propNullableAny
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.funT()
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.funAny()
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.funNullableT()
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.Int")!>b<!>.funNullableAny()
}
