package com.example.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ColdFlowTest {
    @Test
    fun createColdFlow() {
        // flow builders
        val flow1 = (1..10).asFlow()
        val flow2 = listOf(1, 2, 3).asFlow()
        val flow3 = flowOf(1, 2, 3)

        // 上面三个写法的本质都是调用flow
        val flow4 = flow {
            for (i in 1..10) {
                emit(i)
            }
        }
    }

    @Test
    fun useColdFlow() {
        runBlocking {
            val flow = (1..10).asFlow()
            flow.map { it * it }
                .filter { it % 2 == 0 }
                // 会在获取到2个满足条件的结果后停止发射更多值，这是Flow的特性（背压支持）
                .take(2)
                .onEach { println(it) }
                .collect()
                // 等价于上面两行代码
//                .collect {
//                    println(it)
//                }

            println("---------------")

            // 转换符操作，本质都是调用transform
            flow
                .transform {
                    emit(it * 2)
                }
                // 重新消费，重新生产。和上面的collect 互不影响。
                .collect { println(it) }
        }
    }
}