package fourth

/**
 * map 계열의 확장 함수를 이용하면 타입을 쉽게 변환할 수 있다.
 * 참고로 map 확장함수는 Iterator, Array, Sequence 인터페이스에 선언되어 있다.
 */
fun main(args: Array<String>) {
    val origin = listOf(65,66,67)

    println(origin.map{ it.toChar()})

    println(origin.mapIndexed{ index, element ->
        println("$index 위치 : $element 값 ")
        element.toChar()
    })
}