package fourth

/**
 * with은 run과 let에 비해 이해하기 쉽고 사용법도 직관적이다.
 * inlin fun <T,R> with(receiver: T, Block: T.() -> R): R{return receiver.block()}
 *
 * T타입의 receiver 매개변수로 받고, 이를 block 배개변수가 가리키는 함수에 바로 넣어 호출하고 있다.
 */

fun main(args: Array<String>) {
    val a = 10
    val b = 100

    with(a*b - b*b) {
        println(this)
    }
}