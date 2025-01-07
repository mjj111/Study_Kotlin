package third

/**
 * 확장 함수를 응용하면, 참조 변수에 null이 지정되어 있어도
 * 함수 호출이 가능하게 할 수 있다.
 * 리시버 타입에 ?을 붙이면 Nullable 리시버이다.
 */
fun String?.isNullPrint(){
    if(this == null) {
        println("문자열이 null")
    }
    println("null아님")
}

fun main(args: Array<String>) {
    val empty: String? = ""
    empty?.isNullPrint()
}