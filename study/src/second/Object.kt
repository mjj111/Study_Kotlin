package second

/**
 * 자바의 객체와 다르게 코틀린에서는 객체의 속성을 필드가 아닌 프로퍼티라고 한다.
 * 이는 프로퍼티가 필드와 Getter, Setter가 합친 개념이기 때문이다.
 * 참고로 Reference Variable은 힙에 프로퍼티를 저장하고,
 * 객체 참조값은 스택에 저장한다.
 * object로 생성된 객체는 똑같이 여러 개를 생성한다 하더라도 서로 다른 타입으로 인식이된다.
 * 즉, 객체 타입에 이름이 없기 때문이다.
 */
fun main(args: Array<String>) {
    val person = object {
        val name: String = "김명준" // property
        val age: Int = 28
    }
    println(person.name)
}