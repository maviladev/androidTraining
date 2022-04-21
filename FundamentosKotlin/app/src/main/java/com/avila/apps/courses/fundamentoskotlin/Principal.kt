package com.avila.apps.courses.fundamentoskotlin

fun main(){
    newTopic("Hola Kotlin v3!")

    newTopic("Variables y Constantes")
    val a = "hola constantes"
    println(a)
    var b = 2
    println("b = $b")

    var objNull: String?
    objNull = null

    var anyObj: Any?
    anyObj = null
    anyObj = "Hi"

}

fun newTopic(topic: String){
    //println(topic)
    //print(topic)

    print("\n=================== $topic ========================\n")
}