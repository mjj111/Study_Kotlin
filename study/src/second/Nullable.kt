package second

/**
 * Nullable 한 Referenct Type Variable의 Member Function에 접근하려면,
 * . 대신 .? 연산자를 사용해야한다.
 * 만약 Nullalbe 타입을 Not-null타입으로 강제 캐스팅하는 방법은 !!을 후에 붙이는 것이다.
 *
 */
fun main(args: Array<String>) {
    var person: Person? = Person("김명준", 21)
    person = null

    var num: Int? = 2
    num?.let {
        println(" null이 아님")
    } ?: println("null 확인")

    // 엘비스 연산자는 null이 아니면 그대로 쓰고 아니면 대처하는 연산자다.
    num ?: println("null 확인")
    num = num ?: 2

    if (num is Nothing?) {
        println("null 확인")
    }

    when (num) {
        null -> println("null 확인")
        else -> println("null이 아님")
    }

    // num이 null이라면 nullPointerException 예외를 발생시킨다.
    num!!.let { println("null일 수는 없어요") }
}