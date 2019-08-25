package box

import animal.Mammal

open class MammalBox <out T : Mammal>(mammal: T) : UnsafeBox<T>(mammal) {

    override fun setValue(value: @UnsafeVariance T) {
        println("SET VALUE ------")
        value.move()
        value.breathe()
        println("----------------")
        println()
        super.setValue(value)
    }

    override fun getValue(): T {
        println("GET VALUE ---------")
        val value = super.getValue()
        value.breathe()
        value.move()
        println("-----------------")
        println()
        return value
    }
}