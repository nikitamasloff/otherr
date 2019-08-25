package animal

class Bear : Mammal() {

    override fun move() {
        println("Bear moves")
    }

    override fun breathe() {
        println("Bear breathes")
    }

    fun proveThanIAmBear() {
        println("I am BEAR")
    }
}