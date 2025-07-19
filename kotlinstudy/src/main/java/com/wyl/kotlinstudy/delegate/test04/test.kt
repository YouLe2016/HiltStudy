package com.wyl.kotlinstudy.delegate.test04

import kotlin.properties.Delegates

private class User {
    var name: String by Delegates.observable("name") { prop, old, new ->
        println("旧值：$old -> 新值：$new")
    }

    /**
     * 感觉还没下面这种写法清晰
     */
    var age: Int = 0
        set(value) {
            println("旧值：$field -> 新值：$value")
            field = value
        }
}

fun delegateTest04() {
    val user = User()
    user.name = "第一次赋值"
    user.name = "第二次赋值"
    user.age = 18
    user.age = 20
}