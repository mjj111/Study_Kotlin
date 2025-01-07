package third

/**
 *  Companion Object는 클래스 안에 포함되는 이름없는 객체로,
 *  어떤 클래스의 모든 인스턴스가 공유하는 객체를 만들고 싶을 때 사용한다.
 * 사실 companion을 붙이지 않고 클래스안에 객체를 선언하면 자동적으로 식별자가 붙어진다.
 */
class Human private constructor() {

    companion object {
        var countCreated = 0
            private set

        fun create(): Human {
            countCreated += 1
            return Human()
        }
    }
}

fun main(args: Array<String>) {
    val a = Human.create()
    val b = Human.create()

    println(Human.countCreated)
}