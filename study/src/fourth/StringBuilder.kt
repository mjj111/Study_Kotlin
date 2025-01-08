package fourth

/**
 * 문자열 간 덧셈 연산은 매번 새로운 문자열 객체를 생성하게 된다.
 * 이는 문자열이 불변(Immutable) 객체이기 때문이며, 문자열을 조작할 때 성능과 메모리 사용 측면에서 비효율적이다.
 *
 * 이러한 문제를 해결하기 위해 StringBuilder를 사용할 수 있다.
 * StringBuilder는 내부적으로 가변(Mutable) 버퍼를 사용하여 문자열을 조작한다.
 * 문자열을 추가하거나 수정할 때 새로운 객체를 생성하지 않고 기존 버퍼를 수정함으로써 성능을 향상시킨다.
 *
 * StringBuilder는 동적 배열처럼 동작하며, 문자열을 추가할 때 다음과 같은 방식으로 처리된다:
 * 1. 버퍼가 충분한 경우: 기존 버퍼에 문자열을 추가.
 * 2. 버퍼가 부족한 경우: 더 큰 버퍼를 할당하고 기존 데이터를 복사한 후 추가.
 *
 * 성능 비교:
 * - 일반 문자열 덧셈(`+`)은 매번 새로운 객체를 생성하므로, 문자열이 커질수록 성능이 저하되고 메모리 사용이 증가한다.
 * - StringBuilder는 동일한 버퍼에서 작업을 수행하여 메모리를 효율적으로 사용하며, 성능이 더 빠르다.
 *
 * 참고:
 * - StringBuilder는 싱글 스레드 환경에서 사용하는 것이 권장된다.
 * - 멀티 스레드 환경에서는 동기화를 제공하는 StringBuffer를 사용할 수 있다.
 *
 * 요약:
 * - StringBuilder는 문자열 조작 시 성능 및 메모리 효율성을 크게 개선할 수 있는 도구이다.
 * - 대규모 문자열 작업 시 반드시 StringBuilder를 사용하는 것이 좋다.
 */
fun main(args: Array<String>) {
    // 일반 문자열 덧셈 (비효율적)
    var result = ""
    for (i in 1..5) {
        result += i.toString()
    }
    println("일반 문자열 덧셈 결과: $result")

    // StringBuilder 사용 (효율적)
    val builder = StringBuilder()
    for (i in 1..5) {
        builder.append(i.toString())
    }
    val efficientResult = builder.toString()
    println("StringBuilder 결과: $efficientResult")
}
