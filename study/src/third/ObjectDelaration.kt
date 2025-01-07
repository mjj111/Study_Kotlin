package third

/**
 * 프로그래밍 중에 프로그램 전체에서 공유할 수 있는 하나뿐인 객체가 필요할 떄가 있다.
 * 이럴 때는 아래와 같이 객체를 선언해서 사용할 수 있다.
 * object 키워드를 통해 객체를 만들게 되면 싱글톤 패턴을 쓰지 않아도 사용할 수 있게된다.
 *
 * 그럼 ojbect 키워드를 통해 접근할 떄 동시성은 어떻게 해결할까?
 *
 *
 * JVM은 클래스 초기화를 스레드 안전하게 보장하기 위해 클래스 로딩과 초기화는 한 번만 실행되도록 동기화된다.
 * 그러나 이는 해당 객체가 하나임을 인정하지 내부 멤버들의 동시 접근에 따른 문제를 해결해준다는 것은 아니다.
 *
 * 그렇기 때문에, Object를 동시에 사용하는 싱글톤 객체이면서 필드를 갖게 한다면,
 * 동시성 문제를 해결해주는 concurrent 프레임워크를 사용하거나, synchronized, 코루틴을 사용하면 된다.
 */
object Person{
    var name: String = ""
    var age: Int = 0
    fun print(){
        println(name + " " + age)
    }
}

fun main(args: Array<String>) {
    Person.name = "singleton"
    Person.age = 28
    Person.print()
}

