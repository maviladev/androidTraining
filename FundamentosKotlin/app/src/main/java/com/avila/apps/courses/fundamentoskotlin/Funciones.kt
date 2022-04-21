package com.avila.apps.courses.fundamentoskotlin

import kotlin.math.abs

fun main() {
    sayHello()
    println(sum(2,3))
    val a = 4
    val b = 3
    println("$a + $b = ${sum(a,b)}")

    newTopic("Infix")
    val c = -3
    println(c.enableAbs(false))
    println(c.enableAbs(true))

    println("$a + $c = ${sum(a,c)}")
    println("$a + $c = ${sum(a,c enableAbs true)}")

    newTopic("SobreCarga")
    showProduct("Soda", "10%")
    showProduct("Pan")
    showProduct("Jugo", validity = "2 por cliente")
}

private fun sayHello() {
    println("Hello functions")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

//fun sum(a: Int, b: Int) = a + b

infix fun Int.enableAbs(enable: Boolean) = if(enable)abs(this) else this

fun showProduct(name:String, promo: String = "Sin promocion", validity: String = "agotar existencias"){
    println("$name = $promo hasta $validity")
}