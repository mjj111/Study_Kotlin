package second

/**
 * 코틀린의 === 연산자는 자바객체의 equals 메서드와 비슷하게 동작한다.
 */
fun main(args: Array<String>) {
    var a = "one"
    var b = "one"
    // ===  연산자는 참조 비교(Reference Equality)를 수행한다.
    println(a === b) //"one"은 JVM의 String Pool에 저장

    b = "on"
    b += "e"
    //코틀린의 문자열은 Immutable이므로, 이 연산은 "on"에 "e"를 추가한 새로운 문자열 객체를 생성한다.
    //이 새로운 문자열 "one"은 JVM의 String Pool에 있는 "one"과 내용은 같지만, 새로운 객체이기 때문에 다른 참조를 가진다.
    println(a !== b)

    var c = "one"
    println(c === a)
}