package animal

import java.lang.IllegalStateException

class Dolphin : Mammal() {

    override fun move() {
        println("Dolphin moves")
    }

    override fun breathe() {
        println("Dolphin breathes")
    }

    fun proveThanIAmDolphin() {
        println("I am DOLPHIN")
    }
}