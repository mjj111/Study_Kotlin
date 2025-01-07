package third

/**
 * 코틀린에서 배열은 클래스이며,
 * size (property)
 * get, set, iterator (member function)을 갖는다.
 */
fun printAll(numbers: Array<Int>): Unit {
    for (number in numbers) println(number)
}
fun main(args: Array<String>) {
    val numbers: Array<Int> = arrayOf(10,20) // arrayOf는 가변인수를 받을 수 있도록 되어있으며 제네릭이 적용되어있다.
    printAll(numbers)
}