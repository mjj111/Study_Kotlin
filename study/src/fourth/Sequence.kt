package fourth

/**
 * Sequence도 List처럼 일련의 데이터를 표현하는 인터페이스로,
 * List와 달리 게으르게 계산하기 때문에 무한대로 데이터를 다룰 수 있다.
 *
 * 참고로 여기서 게으르다는 것은, 게으르게 로딩한다는 것으로 미리 계산하는게 아닌
 * 필효한 시점에 계산한다는 것을 의미한다.
 *
 * Sequence는 크기가 정해져있지 않아 size나 length 같은 프로퍼티는 포함하지 않는다.
 * 또한 Sequnce인터페이스는 Iterator 연산자 멤버함수만 들어가있다.
 */

fun main(args: Array<String>) {
    var sequence: Sequence<Int> = sequenceOf(1, 2, 3)

    for(i in sequence) {println(i)}
}