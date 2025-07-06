package com.example.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.random.Random

class StateFlowTest {
    class ViewModel {
        private val _age = MutableStateFlow(0)
        val age: StateFlow<Int>
            get() = _age

        suspend fun updateAge() {
            _age.value = request()
        }

        private suspend fun request(): Int {
            delay(2000)
            return Random.nextInt(20, 60)
        }
    }

    @Test
    fun testStateFlow() = runBlocking {
        val viewModel = ViewModel()
        launch {
            viewModel.age.collect {
                println("ui更新年龄：$it")
            }
        }
        launch {
            while (isActive) {
                viewModel.updateAge()
            }
        }
        Unit
    }
}