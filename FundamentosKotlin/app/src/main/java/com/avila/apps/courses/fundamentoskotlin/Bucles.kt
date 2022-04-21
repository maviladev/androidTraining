package com.avila.apps.courses.fundamentoskotlin

fun main() {
    newTopic("Bucles")
    showPersons("Angel", "Mary", "Fany")
    showPersons("Tony", "Julito")
}

fun showPersons(p1: String, p2: String, p3:String){
    println(p1)
    println(p2)
    println(p3)
}

fun showPersons(vararg persons: String){
    println(persons[0])
    println(persons[1])
}