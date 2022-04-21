package com.avila.apps.courses.fundamentoskotlin

fun main() {
    sayHello()
    println(sum(2,3))
    val a = 4
    val b = 3
    println("$a + $b = ${sum(a,b)}")
}

private fun sayHello() {
    println("Hello functions")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

//fun sum(a: Int, b: Int) = a + b