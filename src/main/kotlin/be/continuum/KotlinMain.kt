package be.continuum

import be.continuum.data.Address
import be.continuum.data.Car
import be.continuum.data.User

fun main(args: Array<String>) {
    val car = Car()
    car.brand = "VW"
    car.model = "Golf"
    car.pollutionCo2 = 114

    val address = Address().apply {
        number = 1337
        street = "Street"
    }

    val user = User().let {
        it.surname = "Jan"
        it.name = "Dockx"
        it.address = address
        it.car = car
    }

    println("Hello, $user!")
}