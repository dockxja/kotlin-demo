package be.continuum

import be.continuum.data.Address
import be.continuum.data.Car
import be.continuum.data.KotlinUser

fun main(args: Array<String>) {

    val user1 = user {
        it.surname = "Tom"
        it.name = "Tytgat"
        it.address = address {
            number = 101
            street = "Kek"
        }
        it.car = car {
            brand = "BMW"
            model = "1"
            pollutionCo2 = 99
        }
    }

    val user2 = user {
        it.surname = "Jan"
        it.name = "Dockx"
        it.address = address {
            number = 1337
            street = "Street"
        }
        it.car = car {
            brand = "VW"
            model = "Golf"
            pollutionCo2 = 114
        }
    }

    println("Hello, $user1 and $user2!")
}

fun user(block: (KotlinUser) -> Unit): KotlinUser {
    val p = KotlinUser()
    block(p)
    return p
}

fun address(block: Address.() -> Unit): Address = Address().apply(block)

fun car(block: Car.() -> Unit): Car = Car().apply(block)