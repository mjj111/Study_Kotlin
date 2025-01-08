package fourth

/**
 * apply 확장 함수는 객체 생성및 초기화 코드를 표현식 하나로 압축할 수 있다.
 *
 */
class Person {
    var name: String = ""
    var age: Int = 0
    var money: Int = 0

    override fun toString(): String {
        return "Person(name='$name', age=$age, money=$money)"
    }
}

fun main() {
    var person = Person().apply{
        this.name = "김명준"
        this.money = 70
        this.age = 28
    }
    println(person)

    person = Person().also {
        person: Person ->
        person.name = "김명"
        person.age = 21
        person.money = 120
    }
    println(person)
}
