package com.wyl.kotlinstudy.delegate.test01

private interface Base {
    fun print()
}

private class BaseImpl(val x: Int) : Base {
    override fun print() {
        println("BaseImpl print $x")
    }
}

private class Derived(base: Base) : Base by base

fun delegateTest01() {
    val base = BaseImpl(10)
    val derived = Derived(base)
    derived.print()
}