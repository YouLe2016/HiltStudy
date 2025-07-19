package com.wyl.kotlinstudy.delegate.test01

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        println("BaseImpl print $x")
    }
}

class Derived(base: Base) : Base by base

fun delegateTest01() {
    val base = BaseImpl(10)
    val derived = Derived(base)
    derived.print()
}