package second

class Point(private val x: Int, private val y: Int) {
    operator fun plus(other: Point): Point{
        return Point(this.x + other.x, this.y + other.y)
    }

    operator fun minus(other: Point): Point{
        return Point(this.x - other.x, this.y - other.y)
    }

    operator fun div(other: Point): Point{
        return Point(this.x / other.x, this.y / other.y)
    }

    operator fun times(other: Point): Point{
        return Point(this.x * other.x, this.y * other.y)
    }

    override fun toString(): String {
        return "(x: $x, y: $y)"
    }

    infix fun from(base: Point): Point{
        return Point(this.x - base.x, this.y - base.y)
    }
}

fun main(args: Array<String>) {
    var p1 = Point(10, 10)
    var p2 = Point(2, 2)

    println(p1 + p2)
    println(p1 - p2)
    println(p1 * p2)
    println(p1 / p2)

    val pt = p2 from p1
    println(pt)
}