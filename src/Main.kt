import animal.Bear
import animal.Dolphin
import animal.Mammal
import box.BearBox
import box.DolphinBox
import box.MammalBox

fun main() {
    val bear = Bear()
    val dolphin = Dolphin()

    val mammalBox: MammalBox<Mammal>
    val bearBox = BearBox(bear)
    val dolphinBox = DolphinBox(dolphin)

    mammalBox = bearBox
    mammalBox.getValue()
    mammalBox.setValue(dolphin)

    val list: MutableList<Number> = mutableListOf<Int>(1)
}