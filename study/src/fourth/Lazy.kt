package fourth

/**
 * lazy 함수를 이용하면 프로퍼티의 값이 필요한 시점에 계산을 시작하게 할 수 있다.
 *
 */
class A {
    var num: Int = 0
    val num2: Int by lazy {num * 5}
}

fun main(args: Array<String>) {
    val first = A()
    println(first.num2)

    val second = A()
    second.num = 2
    println(second.num2)
}