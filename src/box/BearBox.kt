package box

import animal.Bear

class BearBox(bear: Bear) : MammalBox<Bear>(bear) {

    override fun setValue(value: Bear) {
        value.proveThanIAmBear()
        super.setValue(value)
    }
}