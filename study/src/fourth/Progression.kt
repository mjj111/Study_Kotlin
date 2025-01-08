package fourth

/**
 * Iterable 인터페이스는 Iterator 멤버함수를 주입하기위한 인터페이스다.
 * 이 인터페이스를 상속하여 반복자를 지원하는 인터페이스가 Progression이다.
 * first, last, step
 * 참고로, step 확장 함수의 인수는 항상 양수다.
 */
fun IntProgression.print(): Unit {
    println("first: $first")
    println("last: $last")
    println("step: $step")
}
fun main(args: Array<String>) {
    var prog: IntProgression = 3..7
    prog.print()

    prog = (3..7).reversed()
    prog.print()

    prog = (3..7)step 3
    prog.print()

    prog = 10 downTo 2 step 3
    prog.print()

    prog = 2 until 5
    prog.print()
}