package be.continuum

import be.continuum.data.KotlinUser
import be.continuum.data.User
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.assertThat
import org.junit.Test
import java.time.LocalDate

class Basics {

    @Test
    fun `if`() {
        // String event;
        // if (LocalDate.now().isEqual(LocalDate.of(2018, 11, 27))) {
        //    event = "Tribe Day"
        // } else {
        //    event = "Not Tribe Day"
        // }
        val event = if (LocalDate.now().isEqual(LocalDate.of(2018, 11, 27))) {
            "Tribe Day"
        } else {
            "Not Tribe Day"
        }
    }

    @Test
    fun elvisOperator() {
        val user = KotlinUser()
        var fallbackUser: User? = null
        val userCar = user.car?.brand
                ?: fallbackUser?.car?.brand
                ?: "BMW"
        assertThat(userCar, equalTo("BMW"))
    }

    @Test
    fun `switch - when`() {
        val x: Int?
        x = 14

        val result = when (x) {
            0, 11 -> "0 or 11"
            in 1..10 -> "from 1 to 10"
            !in 12..14 -> "not from 12 to 14"
            else -> if (x and 1 == 0) "is odd" else "otherwise"
        }
        assertThat(result, equalTo("is odd"))

        /*
        switch (x){
          case 0:
          case 11:
            result = "0 or 11";
            break;
          case 1:
          case 2:
            //...
          case 10:
            result = "from 1 to 10";
            break;
          default:
            if (x <= 12 && x => 14) {
              result = "not from 12 to 14";
              break;
            }
        
            if (x & 1 == 0) {
              result = "is odd";
              break;
            }
        
            result = "otherwise";
        }
         */
    }

    @Test
    fun `if else - when`() {
        val x: Int?
        x = 14

        val result = when {
            x < 0 -> "is Negative"
            x == 0 -> "is Zero"
            x and 1 == 0 -> "is odd"
            else -> "otherwise"
        }
        assertThat(result, equalTo("is odd"))

        /*
        if (isNegative(y)) {
            result = "is Negative";
        } else if (isZero(y)) {
            result = "is Zero";
        } else if (isOdd(y)) {
            result = "is Odd";
        } else {
            result = "otherwise";
        }
         */
    }

    @Test
    fun range() {
        for (i in 1..5) {
            println("Loop $i")
        }
    }

    @Test
    fun rangeUntil() {
        for (i in 0 until 5) {
            println("Loop $i")
        }
    }

    @Test
    fun forLoop() {
        val carBrands = createCarBrandsArray()
        for (brand in carBrands) {
            println("Brand ${brand.toUpperCase()}")
        }
    }

    @Test
    fun forStream() {
        val carBrands = createCarBrandsArray()
        val filteredCarBrands = carBrands.filterNot({ it -> it == "Skoda" }).toList()
        assertThat(filteredCarBrands, not(hasItem("Skoda")))
    }

    @Test
    fun forWithIndexDestructuring() {
        val carBrands = createCarBrandsArray()
        for ((index, brand) in carBrands.withIndex()) {
            println("$index: $brand")
        }
    }

    private fun createCarBrandsArray() = arrayOf("BMW", "Audi", "Volkswagen", "Skoda", "Volvo")

    @Test
    fun forMap() {
        val map = hashMapOf<String, Int>()
        map["one"] = 1
        map["two"] = 2

        for ((key, value) in map) {
            println("Key: '$key', value: '$value'")
        }
    }

    @Test
    fun forMapLazy() {
        val map: Map<String, Int> by lazy {
            println("Computed!")
            mapOf(
                    "one" to 1,
                    "two" to 2
            )
        }

        println("Value for one: '${map["one"]}'")
        println("Value for two: '${map["two"]}'")
    }

    @Test
    fun groupBy() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val groups = numbers.groupBy {
            if (it and 1 == 0) "even" else "odd"
        }
        println(groups)
    }

    @Test
    fun smartCasting() {
        val user: Any = KotlinUser().apply {
            name = "Doe"
            surname = "John"
        }

        if (user is KotlinUser) {
            println("Hello, ${user.name}")
        }
        /*
        * Java
        * if (user instanceof KotlinUser) {
        *   KotlinUser castedValue = (KotlinUser) user;
        *   System.out.println(String.format("Hello, %s", castedValue.getName()));
        * }
        */
    }

    @Test
    fun extensionTest() {
        var field: String? = null
        assertThat(field.isNotNullOrBlank(), `is`(false))
        field = ""
        assertThat(field.isNotNullOrBlank(), `is`(false))
        field = "Hello World!"
        assertThat(field.isNotNullOrBlank(), `is`(true))
    }

    @Test
    fun rawString() {
        println("Hello World!\n" +
                "This shows the inconvenience of a regular string.\n" +
                "\tEscaping required!")

        println("""
            |Hello World!
            |This shows the convenience of a raw string.
            |   No escaping required!
        """.trimMargin(marginPrefix = "|"))
        // "|" is default so it can be omitted.

        println("C:\\Program Files\\Java\\")
        println("""C:\Program Files\Java""")
    }

    @Test
    fun inlineFunction() {
        inlinedFunction {
            println("do something here")
        }

        // No function instance will be created!
        // The code around the invocation block is copied to the call site.
        // Compiles to:
        // println("before")
        // println("do something here")
        // println("after")
    }

    private inline fun inlinedFunction(body: () -> Unit) {
        println("before")
        body.invoke()
        println("after")
    }

    @Test
    fun singleton() {
        SingletonExample.hello()
        SingletonExample.hello()
        SingletonExample.hello()
    }

    private class Z(private val z: Int): Y(0), X {
        override fun x() {
            println(y)
        }
    }

    // Class should be explicitly open or abstract to be extendable. Final by default!
    private abstract class Y(internal val y: Int): X

    private interface X {
        fun x()
    }

}