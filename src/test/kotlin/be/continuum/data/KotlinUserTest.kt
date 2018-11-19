package be.continuum.data

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class KotlinUserTest {

    @Rule
    @JvmField
    val expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun createUser() {
        val user = KotlinUser(name = "Doe", surname = "John")

        assertThat(user.getFullName(), equalTo("John Doe"))
        assertThat(user.surname, equalTo("John"))
        assertThat(user.name, equalTo("Doe"))
        assertThat(user.age, nullValue())
        assertThat(user.toString(), equalTo("KotlinUser(surname=John, name=Doe)"))
    }

    @Test
    fun `Create user with age`() {
        val user = createJohnDoeUser()
        user.age = 30

        assertThat(user.getFullName(), equalTo("John Doe"))
        assertThat(user.age, equalTo(30))
        assertThat(user.toString(), equalTo("KotlinUser(surname=John, name=Doe)"))
    }

    private fun createJohnDoeUser() = KotlinUser("John", "Doe")

    private fun KotlinUser.getFullName(): String {
        return "$surname $name"
    }

    @Test
    fun createUserCopy() {
        val user = createJohnDoeUser()
        assertThat(user.surname, equalTo("John"))
        assertThat(user.name, equalTo("Doe"))
        assertThat(user.age, nullValue())

        val copy = user.copy(surname = "Johan")
        assertThat(copy.surname, equalTo("Johan"))
        assertThat(copy.name, equalTo("Doe"))
        assertThat(copy.age, nullValue())
    }

    @Test
    fun destructuringDeclaration() {
        val user = createJohnDoeUser()
        val (surname, name) = user

        assertThat(surname, equalTo("John"))
        assertThat(name, equalTo("Doe"))
    }

    @Test
    fun nullSafety() {
        val user: User? = null
        assertThat(user?.name, nullValue())
    }

    @Test
    fun createJavaUser() {
        val user = User()
        user.surname = "John"
        user.name = "Doe"
        user.age = 30

        assertThat(user.surname, equalTo("John"))
        assertThat(user.name, equalTo("Doe"))
        assertThat(user.age, equalTo(30))
    }

}