package second

/**
 * 코틀린에서는 자바와 달리,
 * 클래스 이름이 파일 이름과 같아야할 의무가 없다.
 * 한 파일 내에 여러 개의 public 클래스를 선언할 수도 있다.
 *
 * 참고로 클래스를 통한 객체를 생성할 때는 new 연산자 없이 생성자만 호출하면 된다.
 * 이는 코틀린의 기본 접근지정자는 기본값이 default인 자바와는 달리 public이다.
 * 정보은닉은 어디갔는가 하고 의문을 가질 수 있지만,
 * 베타 버전에서 internal 이었으나 자바의 수많은 클래스와 메서드들이 public으로 선언되어 있다는 점 때문에 public으로 바꾸게 되었다.
 * (생성자도 클래스랑 네이밍 같아서 constructor 사용하는걸 보니, 간결한 코드를 중시하는 코틀린 정신인듯)
 */

class Person1 constructor(name: String, age: Int) {
    var name: String = ""
    var age: Int = 0

    init {
        this.name = name
        this.age = age
    }
}

class Person2 {
    //property
    var name: String = ""
    var age: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    // Member function
    fun printName(): Unit{
        println(name)
    }
}
class Person3 constructor(val name: String, val age: Int) {
}


fun main(args: Array<String>) {
    val person1 = Person1("김명준", 20)
    val person2 = Person2("김형준", 21)
    val person3 = Person3("김혜인", 22)

    println(person1.name)
    println(person2.name)
    println(person3.name)

    person2.printName()
}