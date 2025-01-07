package third

/**
 * 함수를 저장할 수 있는 타입을 functionType이라고한다.
 * 함수 리터럴이란, 말 그대로 함수를 나타내는 리터럴이란 뜻이다.
 * -> 를 경계로 매개변수와 함수의 내용이 분리되는데,
 * 함수 리터럴에는 return을 적지 않는다. 그 대신, 함수 리터럴의 반환값은 함수 내용의 맨 마지막 표현식이 된다.
 * 이러한 표현을 람다식(LambdaExpression)이라고 한다.
 */

fun main(args: Array<String>) {
    // 람다식으로 함수 리터럴 정의
    val instantFunc = { number: Int ->
        println("$number 가 들어옴")
        number + 2 // 마지막 표현식이 반환값
    }

    // 함수 호출
    val result = instantFunc(1)
    println("결과: $result")
}