package com.avila.apps.courses.fundamentoskotlin.classes

import com.avila.apps.courses.fundamentoskotlin.newTopic

fun main() {

    newTopic("Clases")
    val phone = Phone(123456789)
    phone.call()
    phone.showNumber()
    //println(phone.number)


    newTopic("Herencia")

    val smartPhone = SmartPhone(123456789, true)

    smartPhone.call()
    newTopic("Sobreescritura")
    smartPhone.showNumber()
    println("Privado ? ${smartPhone.isPrivate}")

    newTopic("Data classes")
    val myUser = User(1,"Marcos","Avila",1)
    println(myUser)

    println(myUser.component3())
}