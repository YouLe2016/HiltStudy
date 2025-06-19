package com.example.hiltstudy.ioc

private class User(
    val name: String,
    var dog: Dog
) {
    fun introduce() {
        println("我的名字是$name, 我的狗叫${dog.name}")
    }
}

private data class Dog(
    val name: String
)

fun main() {
    // 对于User而言，Dog对象是通过构造器注入的
    val user = User("张三", Dog("旺财"))
    user.introduce()
    // set方法注入
    user.dog = Dog("大黄")
    user.introduce()
    // 获取当前字符编码格式，并输出
    val currentCharset = java.nio.charset.Charset.defaultCharset()
    println("当前字符编码格式是：$currentCharset")
}