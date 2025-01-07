package first

/**
 * 아래와 같이 사용하면 자동적으로 tmp는 변수 타입이 Int가 된다.
 * tmp1은 자동적으로 double이 된다. 물로 선언해줘도 괜찮다.
 * 참고로 코틀린은 자바보다 타입 체크에 더 엄격하여 Double 타입 선언된 벼수에 Int 타입의 값을 지정할 수 없다.
 * 이는! 자체 형변환을 위한 키워드가 존재하지만 각 타입이 서로 상속관계가 아니기 때문에 캐스팅으로 형변환을 할 수는 없다.
 * 그렇기 떄문에 해당 객체의 형변환 함수를 호출하여 변환하도록 한다.
 */
fun main(args: Array<String>) {
    val tmp = 10 + 2 - 5
    println(tmp)

    val tmp1 = 7.5 + 2.1
    println(tmp1)

    val tmp2: Double = 7.2
    println(tmp2)

    val tmp3: Double = tmp.toDouble()
    println(tmp3)
}