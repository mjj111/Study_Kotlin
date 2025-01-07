package third

/**
 * 확장 함수를 아래와 같이 선언하면 동반자 객체에도 확장 함수를 달 수 있다.
 *
 */

class Parent{ companion object}

fun Parent.Companion.create() = Parent()

fun main(args: Array<String>) {
    Parent.create()
}