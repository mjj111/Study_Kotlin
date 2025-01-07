package third

/**
 * A<Int>가 A<Any>의 서브타입이라고 착각할 수 있느넫,
 * 전혀 아니다.
 * 그러나, 타입 매개변수에 in/out 키워드를 붙여 ,
 * 업캐스팅, 다운캐스팅이 가능해진다.
 *
 * out = ? extend T   -> 서브타입을 슈퍼타입에 대입할 수 있게된다.
 * in = ? super T  -> 슈퍼타입을 서브타입에 대입할 수 있게된다.
 */
class A<out T>
class B<in T>

fun main(args: Array<String>) {
    val aSub = A<Int>()
    val aSuper: A<Any> = aSub

    val bSuper = B<Any>()
    val bSub: B<Int> = bSuper

    val start: A<*> = aSub
}