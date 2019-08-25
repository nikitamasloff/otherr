package box

import animal.Dolphin

class DolphinBox(dolphin: Dolphin) : MammalBox<Dolphin>(dolphin) {

    override fun setValue(value: Dolphin) {
        value.proveThanIAmDolphin()
        super.setValue(value)
    }
}