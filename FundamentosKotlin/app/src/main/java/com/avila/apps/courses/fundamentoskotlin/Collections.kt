package com.avila.apps.courses.fundamentoskotlin

fun main() {
    newTopic("Colecciones")
    newTopic("Solo lectura")

    val fruitList = listOf<String>("Manzana", "Platano", "Uva", "Lima")
    println(fruitList.get((0..fruitList.size - 1).random()))

    println("Index de uva es ${fruitList.indexOf("Uva")}")
}