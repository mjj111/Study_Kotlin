package third

/**
 * 추상 클래스는 일부 멤버의 내용이 비어있는 불완전한 클래스이기 때문에
 * 객체를 생성할 수 없다.
 * abstract 키워드는 그 자체로, open이다.
 * 추가적으로 추상 클래스는 추상 멤버 함수를 가질 수 있는데, 여기서 추상 멤버 함수는 내용이없는 멤버함수를 의미한다.
 * ++ 물론 추상 프로퍼티도 가능하다.
 *
 * 추상 클래스를 상속하는 일반 클래스는 모든 추상 멤버 함수를 오버라이딩 해야한다.
 */
abstract class Car {
    abstract fun getVolume(): Int
}

class Morning(private val firstVolume: Int): Car() {
    override fun getVolume() = -firstVolume
}

class Ramborogini(private val firstVolume: Int): Car() {
    override fun getVolume() = firstVolume * 10
}

fun main(args: Array<String>) {
    val morning: Car = Morning(1)
    val ramborogini: Car = Ramborogini(1)

    println(morning.getVolume())
    println(ramborogini.getVolume())
}