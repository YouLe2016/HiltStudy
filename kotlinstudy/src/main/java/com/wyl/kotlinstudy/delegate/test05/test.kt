package com.wyl.kotlinstudy.delegate.test05

// 如果使用 var 属性，需要把 Map 换成 MutableMap
private class Site(map: Map<String, Any?>) {
    val name: String by map
    val url: String by map
}

private fun main() {
    val map = mapOf(
        "name" to "菜鸟教程",
        "url" to "www.runoob.com"
    )

    val site = Site(map)
    println(site.name)
    println(site.url)
}