package com.wyl.kotlinstudy.delegate.test03

private val name: String by lazy {
    println("name init")
    "小白"
}

private val age: Int by lazy(::obtainAge)

private fun obtainAge() : Int {
    println("age init")
    return 32
}

private var school: String = ""
    get() {
        if (field.isEmpty()) {
            field = obtainSchool()
        }
        return field
    }

private fun obtainSchool(): String {
    println("school init")
    return "清华大学"
}

fun delegateTest03() {
    println("程序运行")
    println(name)
    println(name)
    println(age)
    println(age)
    println(school)
    println(school)
}