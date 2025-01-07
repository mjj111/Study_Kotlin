package first

/**
 * 코틀린은 자바와 다른게 String에서 인덱스에 위치한 문자를 추출하는데 있어서 함수가 아닌
 * 배열에서 접근하듯이 사용이 가능하다. + 추가는 가능하지만 삭제 불가
 */
fun main(args: Array<String>): Unit {
    var str: String = "Hello"
    println(str)

    str = str + "Kotlin"
    println(str)

    println(str[1].code == 'e'.code)
    println(str[1] == 'e')
}