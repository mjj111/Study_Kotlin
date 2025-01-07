package second

/**
 * Noting 타입은 실행 흐름이 도달할 수 없는 구역을 나타내기 위한 특수 타입이다.
 * Noting 타입의 표현식은 throw Exception 인데, Int 타입으로 인식된다.
 * 만약 표현식이 아니라면 Unit이 되기 때문에 if else 를 사용할 수 없게 된다.
 */
fun throwing(): Nothing {
    throw Exception()
}
fun main(args: Array<String>) {
    println("start")
    val i: Int = throwing()
    println(i)
}