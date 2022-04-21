package com.avila.apps.courses.fundamentoskotlin

fun main() {
    newTopic("Bucles")
    showPersons("Angel", "Mary", "Fany")
    showPersons("Tony", "Julito", "Pepe", "Taka")
}

fun showPersons(p1: String, p2: String, p3:String){
    println(p1)
    println(p2)
    println(p3)
}

fun showPersons(vararg persons: String) {
    newTopic("For")
    for (person in persons)println(person)

    newTopic("While")
    var index = 0
    while (index < persons.size){
        if (persons[index] == "Julito") println("Es Julito!")
        println(persons[index])
        index++
    }

    newTopic("When")
    index = (0..persons.size-1).random()
    when(persons[index]){
        "Tony" -> println("Es tony!")
        "Julito" -> println("Es Julito!")
        else -> println(persons[index])
    } 
}