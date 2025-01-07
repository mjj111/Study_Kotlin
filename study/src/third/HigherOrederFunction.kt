package third

/**
 * 함수 리터럴은 보통 고차 함수를 위해 사용된다.
 * 고차함수란, 인수로함수를 받거나 함수를 반환하는 함수를 뜻한다.
 * 만약 고차 함수의 마지막 매개변수 타입이 함수 타입이라면 함수 호출시 소괄호를 생략할 수 있다.
 * 만약, 고차함수의 매개변수가 여러개고 마지막에 함수타입의 매개변수가 맨 마지막에 온다면,
 * 일반 인수들만 소괄호로 감싸고 함수리터럴은 바깥으로 뺄 수 있다.
 */
fun decorate(number: Int, task: () -> Unit) {
    println("--$number 받고 작업 시작--")
    task()
    println("--작업 끝--")
}

fun main(args: Array<String>) {
    decorate(2){
        println("작업하자 작업")
    }
}