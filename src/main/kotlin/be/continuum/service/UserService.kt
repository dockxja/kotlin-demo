package be.continuum.service

import be.continuum.data.KotlinUser

class UserService {

    fun saveUser(user: KotlinUser) {
        fun validate(value: String?, fieldName: String) {
            if (value.isNullOrBlank()) {
                throw IllegalArgumentException("Can't save user $user: empty $fieldName")
            }
        }

        validate(user.name, "Name")
        validate(user.surname, "Surname")

        // Perform save
    }

}