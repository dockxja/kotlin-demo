package be.continuum.ui

class Button : Clickable, Focusable {

    override fun click() {
        println("I'm clicked!")
    }

    override fun showOff() {
        super<Clickable>.showOff()
    }

}