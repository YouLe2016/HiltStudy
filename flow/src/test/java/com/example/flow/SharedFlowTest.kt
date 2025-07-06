package com.example.flow

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SharedFlowTest {
    @Test
    fun testSharedFlow() = runBlocking {
        val flow = MutableSharedFlow<Int>(
            //重播次数。可以打印出7 8 9
            //replay = 3,
            //缓存区大小。发两个才开始collect
            extraBufferCapacity = 1,
            /*
             * 缓存溢出策略。
             * BufferOverflow.SUSPEND: 挂起等待
             * BufferOverflow.DROP_OLDEST: 丢弃最老的
             * BufferOverflow.DROP_LATEST: 丢弃最新的
             */
            onBufferOverflow = BufferOverflow.SUSPEND
        )
        flow.onEach(::println)
            // 挂起了，不会执行下面的函数
            //.collect()
            .launchIn(this)
        delay(1000)
        repeat(10) {
            println("开始发送 $it")
            flow.emit(it)
        }
        Unit
    }
}