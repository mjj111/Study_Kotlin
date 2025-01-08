package third

/**
 * sealed 클래스는 자신의 중첩(nested) 클래스에만 상속을 허용하는 클래스다.
 */
sealed class Outer{
    class One: Outer()
    class Two: Outer()
    class Three: Outer()
}

fun main(args: Array<String>) {
    val instance: Outer = Outer.Three()

    val text: String = when(instance) {
        is Outer.Three -> "Three"
        is Outer.Two -> "Two"
        is Outer.One -> "One"
    }
    println(text)
}