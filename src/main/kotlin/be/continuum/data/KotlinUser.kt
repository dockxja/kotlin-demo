package be.continuum.data

data class KotlinUser(
        var surname: String? = null,
        var name: String? = null,
        var age: Int? = null,
        var address: Address? = null,
        var car: Car? = null)