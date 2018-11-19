package be.continuum

import be.continuum.data.Address
import be.continuum.data.Car
import be.continuum.data.User

fun main(args: Array<String>) {
    val car = Car()
    car.brand = "VW"
    car.model = "Golf"
    car.pollutionCo2 = 114

    val address = Address()
    address.number = 1337
    address.street = "Street"

    val user = User()
    user.surname = "Jan"
    user.name = "Dockx"
    user.address = address
    user.car = car

    println(String.format("Hello, %s!", user))
}