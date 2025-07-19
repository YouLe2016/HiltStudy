package com.wyl.kotlinstudy.delegate.test02

import kotlin.reflect.KProperty

class Example {
    var property: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 感谢你将 '${property.name}' 委托给我!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value 已经赋值给 $thisRef 中的 '${property.name}'.")
    }
}

fun delegateTest02() {
    val example = Example()
    println(example.property)

    example.property = "姓名"
    println(example.property)
}