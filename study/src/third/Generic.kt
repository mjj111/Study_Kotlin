package third

/**
 * Generic 문법을 이용하면, 인수를 전달하듯이 함수에 타입을 전달할 수 있다.
 * 타입 매개변수를 두개로 받을 수도 있으며, mapper 매개변수에는 T타입을 R타입으로 변환하는 함수를 받도록 했다.
 * 화장 함수의 리시버에도 타입 매개변수를 적용할 수 있다.
 */

fun <T> todo(value: T): () -> T = {value}

fun <T, R> T.map(mapper:(T) -> R): R {
    return mapper(this)
}

// 타입 매개변수에 is를 사용하고 싶다면 아래처럼 사용해야한다.
inline fun <reified T> check(input: Any) {
    if (input is T) println("input은 제네릭과 같습니다.")
    else println("input은 제네릭과 다릅니다.")
}

fun main(args: Array<String>) {
    val func: () -> Int = todo<Int>(101)
    println(func())

    val square: Int = 11.map{it * it}
    println(square)

    check<Int>(10)
    check<Int>("dd")
}