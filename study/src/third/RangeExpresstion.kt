package third

/**
 * 코틀린에서는 범위를 표현하는 연산자가 있다.
 */
fun main(args: Array<String>) {
    val ontToTen: IntRange = 1..10
    val upperAtoZ: CharRange = 'A'..'Z'

    if ('C' in upperAtoZ) {
        println("C는 대문자")
    }

    if (1 in ontToTen) {
        println("1은 1에서 10 안 숫자")
    }
}