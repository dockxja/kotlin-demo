package be.continuum

import be.continuum.data.Address
import be.continuum.data.Car
import be.continuum.data.KotlinUser

fun main(args: Array<String>) {
    val car = Car()
    car.brand = "VW"
    car.model = "Golf"
    car.pollutionCo2 = 114

    val address = Address().apply {
        number = 1337
        street = "Street"
    }

    val user = KotlinUser().let { user ->
        user.surname = "Jan"
        user.name = "Dockx"
        user.address = address
        user.car = car
        user
    }

    println("Hello, $user!")
}