package com.avila.apps.courses.fundamentoskotlin

import com.avila.apps.courses.fundamentoskotlin.classes.Group
import com.avila.apps.courses.fundamentoskotlin.classes.User

fun main() {
    newTopic("Colecciones")
    newTopic("Solo lectura")

    val fruitList = listOf<String>("Manzana", "Platano", "Uva", "Lima")
    println(fruitList.get((0..fruitList.size - 1).random()))

    println("Index de uva es ${fruitList.indexOf("Uva")}")

    newTopic("Mutable list")

    val myUser = User(1,"Marcos","Avila", Group.FRIEND.ordinal)
    val bro = myUser.copy(0, "Ivan", "Kepler", Group.FAMILY.ordinal)
    val workPal = myUser.copy(3, "Peter", "Chill", Group.WORK.ordinal)

    val usersList = mutableListOf(myUser, bro)
    println(usersList)

    usersList.add(workPal)
    println(usersList)

    usersList.removeAt(1)
    println(usersList)

    usersList.remove(myUser)
    println(usersList)

    val usersSelectedList = mutableListOf<User>()
    println(usersSelectedList)

    usersSelectedList.addAll(usersList)
    println(usersSelectedList)

    usersSelectedList.add(myUser)
    println(usersSelectedList)

    usersSelectedList.set(1, bro)
    println(usersSelectedList)

    usersSelectedList.add(myUser)
    usersSelectedList.add(myUser)
    usersSelectedList.add(myUser)
    usersSelectedList.add(myUser)
    println(usersSelectedList)

}