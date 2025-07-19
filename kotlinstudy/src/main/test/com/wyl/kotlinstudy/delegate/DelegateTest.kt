package com.wyl.kotlinstudy.delegate

import com.wyl.kotlinstudy.delegate.test01.delegateTest01
import com.wyl.kotlinstudy.delegate.test02.delegateTest02
import com.wyl.kotlinstudy.delegate.test03.delegateTest03
import com.wyl.kotlinstudy.delegate.test04.delegateTest04
import kotlin.test.Test

class DelegateTest {
    @Test
    fun test1() {
        delegateTest01()
    }

    @Test
    fun test2() {
        delegateTest02()
    }

    @Test
    fun test3() {
        delegateTest03()
    }

    @Test
    fun test4() {
        delegateTest04()
    }
}