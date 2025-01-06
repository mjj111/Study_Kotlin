/**
 * 코틀린은 함수 선언을 파이썬과 같이 가볍게 선언이 가능하다.
 * 또한 파라미터로 받은 변수와 동일한 식별자로 함수 내부에서 선언해 사용할 수는 없다.
 *  코틀린에서 파라미터로 들어온 객체는 val로 불변해서 그렇다.
 *
 *  자바와 달리 void 대신에 Unit이라는 키워드를 사용한다.
 *  재밌는 점은 Unit은 class 키워드로 정의된 일반 타입으로 void 클래스와 비슷한 개념이라고 보면 된다.
 *  그리고 Unit 객체는 싱글톤 인스턴스이기 때문에 매번 객체를 생성하지 않는다. (순수 함수라서 가능하다)
 *  또한 하나의 문장으로 구성된 함수가 있다면 변수로 선언하여 사용할 수 있다. (람다)
 */

fun main(args: Array<String>) {
    var a: Int = 1
    println(m1(a))
    println(m1(a) + 1)
    m2()
    fun m3() = println("Hello World")
    m3()
    println(getSum(1))
    println(getSum(1,2,3))
}

//가변 인수를 받을 시 vararg를 사용할 수 있다. 참고로 자바에서는 키워드 ... 가 있다
fun getSum(vararg numbers: Int): Int {
    var total = 0
    for(number in numbers) total += number
    return total
}

fun m2(defaultValue : Int = 111) {
    println(defaultValue)
}


fun m1(a: Int): Int {
    //a = 1 이 불가, val 이 된다.
    var tmp = a + 1
    return tmp
}

