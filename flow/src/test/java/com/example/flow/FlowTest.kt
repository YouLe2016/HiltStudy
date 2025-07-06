package com.example.flow

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.lang.Thread.sleep

/**
 * 循环10次网络请求，获取结果
 * 进行平方操作
 * 过滤掉奇数
 * 取前两个
 * 打印结果
 */
class FlowTest {
    @Test
    fun notUseFlow() = runBlocking {
        List(10) {
            request()
        }
            .map { it * it }
            .filter { it % 2 == 0 }
            .take(2)
            .forEach { println(it) }
    }

    /**
     * 异步优化
     */
    @Test
    fun notUseFlowAsync() = runBlocking {
        List(10) {
            async {
                request()
            }
        }
            .awaitAll()
            .map { it * it }
            .filter { it % 2 == 0 }
            .take(2)
            .forEach { println(it) }
    }

    @Test
    fun userFlow() = runBlocking {
        flow {
            repeat(10) {
                emit(
                    request()
                )
            }
        }
            .map { it * it }
            .filter { it % 2 == 0 }
            // 会在获取到2个满足条件的结果后停止发射更多值，这是Flow的特性（背压支持）
            .take(2)
            // 没有 collect() 的话，flow()的block不会执行
            .collect { println(it) }
    }

    /**
     * Dispatchers.IO
     * 如果是request耗时操作，请使用Dispatchers.IO
     */
    private fun requestSleep(): Int {
        sleep(2000)
        val result = (1..10).random()
        println("request result=$result")
        return result
    }

    private suspend fun request(): Int {
        delay(1000)
        val result = (1..10).random()
        println("request result=$result")
        return result
    }
}