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

fun showPersons(vararg persons: String) {
    newTopic("For")
    for (person in persons)println(person)

    newTopic("While")
    var index = 0
    while (index < persons.size){
        println(persons[index])
        index++
    }
}