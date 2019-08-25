package box

open class UnsafeBox <out T : Any>(private var value: T) {

    open fun setValue(value: @UnsafeVariance T) {
        this.value = value
    }

    open fun getValue(): T = value
}