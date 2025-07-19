package com.wyl.kotlinstudy.delegate

import com.wyl.kotlinstudy.delegate.test01.delegateTest01
import com.wyl.kotlinstudy.delegate.test02.delegateTest02
import com.wyl.kotlinstudy.delegate.test03.delegateTest03
import kotlin.test.Test

class DelegateTest {
    @Test
    fun testDelegate1() {
        delegateTest01()
    }

    @Test
    fun testDelegate2() {
        delegateTest02()
    }

    @Test
    fun testDelegate3() {
        delegateTest03()
    }

}