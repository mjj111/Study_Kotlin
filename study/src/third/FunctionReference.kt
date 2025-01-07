package third

/**
 * 함수 타입 변수는 이미 선언되어 있는 함수나 객체의 멤버 함수를 가리킬 수도 있다.
 */

fun plus(a: Int, b: Int): Unit {
    println(a + b)
}

object Object{
    fun minus(a: Int, b: Int) {
        println(a - b)
    }
}

class Class {
    fun average(a: Int, b: Int) {
        println((a + b) / 2)
    }
}

fun main(args: Array<String>) {
    var instantFunc :(Int, Int) -> Unit
    instantFunc = ::plus
    instantFunc(1, 2)

    instantFunc = Object::minus
    instantFunc(1, 2)

    instantFunc = Class()::average
    instantFunc(1,10)
}