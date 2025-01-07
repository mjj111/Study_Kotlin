package third

/**
 * 코틀린의 for문은 for each 스타일만 지원하여, C 스타일의 전통적인 for는 지원하지 않는다.
 * 그렇기 떄문에 for (변수 이름 : 타입 in 표현식) 을 따른다.
 * in 우측의 표현식은 연산자 멤버 함수를 갖는 객체만 지정할 수 있다.
 * operator fun interator(): Interator<T>
 *
 * + 참고로 코틀린 컴파일러는 IntRange가 적용된 for문을 다음과 같은 꼴로 최적화해준다.
 * for(int i = 0; i< 10; i++)
 * 따라서, 빈번한 객체 생성으로 인한 성능 저하는 크게 걱정하지 않아도 된다.
 */
fun main(args: Array<String>) {

    for (i: Int in 1..3) {
        println(i)
    }

    // 위 for문과 아래와 같다 생각하면 된다.
    val range: IntRange = 1..3
    val iter: Iterator<Int> = range.iterator()

    while (iter.hasNext()) {
        println(iter.next())
    }
}