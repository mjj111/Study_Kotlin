package second

/**
 * 코틀린은 자바와 달리 기본적으로 클래스는 final로 되어있기 때문에
 * 상속을 사용할 때는, open 키워드를 사용한다.
 */
open class Person(val name: String, val age: Int) {
    open fun func() = println("Person")
}

class Student(name: String, age: Int, val id: Int) : Person(name, age) {
    override fun func() {
        super.func()
        println("Student")
    }
}

fun main(args: Array<String>) {
    val person = Person("김명준",28)
    //UpCasting 가능
    val student: Person = Student("김명준",28, 202111432)
    student.func()

    //DownCasting 부분 가능
    try {
        val castered1 = student as Person
    } catch (e: Exception) {
        println("실패")
    }
    try {
        val castered2 = person as Student
    } catch (e: Exception) {
        println("다운캐스팅 실패")
    }

    // 자바의 instance of
    if(student is Student){
        println("학생")
    }
}