package third

/**
 * 클래스의 프로퍼티는 선언과 동시에 초기화하거나 init 블록 안에 반드시 초기화해줘야한다.
 * 그러나 이런 강제성은 너무 불편한데 사용자 정의 클래스의 경우 초기화가 늦어져야한다.
 * 이를 유예하는 키워드가 lateinit이다.
 */
class Point(val x: Int, val y: Int) {}

class Rectangle{
    lateinit var point1: Point
    lateinit var point2: Point

    //isInitialized는 lateinit 프로퍼티를 확인할 때 사용할 수 있는, (런타입) Reflection API다.
    // 참고로, isInitialized는 lateinit 프로퍼티를 반사(Reflection)를 통해 확인할 수 있지만,
    // 이 작업은 :: 연산자를 통해 클래스 내부에서만 사용 가능하다.
    fun isPoint1Initialized(): Boolean = this::point1.isInitialized
    fun isPoint2Initialized(): Boolean = this::point2.isInitialized

    val width: Int get() = point2.x - point1.x
    val height: Int get() = point2.y - point1.y
    val area: Int get() = width * height
}

fun main(args: Array<String>) {
    val rect = Rectangle()
    rect.point1 = Point(10, 20)
    rect.point2 = Point(15, 25)
    println(rect.area)
    println(rect.width)
    println(rect.height)

    // 프로퍼티 초기화 확인
    println("point1 초기화 여부: ${rect.isPoint1Initialized()}")
}