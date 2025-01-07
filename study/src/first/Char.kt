package first

/**
 * 자바와 동일하게 코틀린에서 Char는 유니코드를 갖고있다.
 * 재밌는점은 바로 사용가능한 정수가 아니라, code를 통해 접근해야한 다는 것이다.
 * 또한 char 타입 리터럴에 정수를 연산하게 되면 char 리터럴이 된다.
 * 정수에 char 타입 리터럴을 연산하게 되면 정수 리터럴이 된다. + 왼쪽 타입이 우선된다.
 */
fun main(){
    var ch: Char = 'A'
    println(ch)

    ch = '\uAC00' // 가
    println(ch)

    ch = '명'
    println(ch)

    println('a'.code) // 97
    println('b'.code) // 98

    println(('b' + 1)) // c
    println((1 + 'b'.code).toChar())
}