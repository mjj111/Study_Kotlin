package third

/**
 * 인터페이스는 클래스에 어떤 멤버 함수와 프로퍼티가 반드시 존재한다는 것을 보장하기 위한 장치다.
 * 멤버 함수, 추상 멤버 함수, 추상 프로퍼티는 가질 수 있으나, 일반 프로퍼티와 생성자는 가질 수 없다.
 *
 * 참고로 인터페이스는 기존의 클래스를 확장한다는 개념보다는
 * 어떤 클래스에 플러그인을 추가한다는 개념에 가깝다. 마치 Comparable이나 Printable 플러그인을 탑재시켰다고 보면 된다.
 */

interface Printable{
    fun print(): Unit
}

class AAA: Printable{
    override fun print(): Unit{
        println("AAA")
    }
}

fun print(any: Printable) {
    any.print()
}

fun main(args: Array<String>) {
    print(AAA())
}