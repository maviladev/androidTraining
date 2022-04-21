package com.avila.apps.courses.fundamentoskotlin

fun main(){
    newTopic("Hola Kotlin v3!")

    newTopic("Variables y Constantes")
    val a = "hola constantes"
    println(a)
    var b = 2
    println("b = $b")
}

fun newTopic(topic: String){
    println(topic)
    print(topic)

    print("\n=================== $topic ========================\n")
}