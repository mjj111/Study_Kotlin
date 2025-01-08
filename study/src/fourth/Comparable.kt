package fourth

class Rectangle(val width: Int, val height: Int): Comparable<Rectangle> {
    val area: Int = width * height

    override fun compareTo(other: Rectangle): Int {
        return area - other.area
    }
}

fun main() {
    val rec1 = Rectangle(42, 42)
    val rec2 = Rectangle(2, 2)
    println(rec1.compareTo(rec2))
    println(rec1 > rec2)
}