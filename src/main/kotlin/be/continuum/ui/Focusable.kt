package be.continuum.ui

interface Focusable {

    fun setFocus(focused: Boolean) {
        println("I ${if (focused) "got" else "lost"} focus.")
    }

    fun showOff() = println("I'm focusable!")

}