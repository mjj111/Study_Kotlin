package first

/**
 * 아래에서 total은 변수의 이름으로, 해당 이름을 식별자라고 한다.
 * 코틀린에서 식별자는 키워드를 제외한, 영문자, 숫자, 언더스코어(_)로만 지을 수 있다.
 * 더불어, 숫자는 맨 앞에 오면 안된다.
 * 코틀린에서는 Camel Case를 따른다.
 *
 * 코틀린은 자바와 달리 Primitive타입이 없다.
 * 즉 모두 클래스란 것인데, 자바의 래퍼클래스가 코틀린에서는 기본타입이 되었다고 생각하면 된다.
 * 그렇다면 성능상 문제는 없을까? 결론부터 말하자면 그렇지 않다.
 * 컴파일러가 어느정도 최적화해주는데, null을 지정하거나 제네릭에 사용하지만 않으면 원시타입을 쓰게끔 자바 바이트코드가 생성된다.
 *
 * 자바에서 사용하는 fnial 키워드를 코틀린에서는 val을 사용한다.
 * var (Variable)
 * val (Variable + Immutable)
 *
 * Int 타입 변수를 하나 선언하면 Ram에 4바이트 만큼 차지한다.
 */
fun main(array: Array<String>) {
    var total = 0

    val valueA: Int = 10 + 3
    val valueB: Int = 10 + valueA

    total = valueA + valueB
    print(total)
}