package fourth

/**
 * run 확장 함수를  이용해서 코드 중복을 줄일 수 있다.
 * inline fun <T,R> T.run(block: T.() -> R): R {return this.block()}
 *
 * 리시버 타입에 제네릭이 적용되어 있기 떄문에 run 확장 함수는 모든 타입에 적용할 수 있다.
 * 즉, run 함수의 립시버로 지정하고 있는 표현식은 bolck  매개변수로 함수를 받아 곧바로 호출하여
 * 확장 함수 덕에 중복되는 표현식을 this로 묶을 수 있다.
 */

fun main(args: Array<String>) {
    val a = 10
    val b = 10

    (a * b - 2 * a).run{
        if (this > 10) println("10보다 큼")
        else println("10보다 작음")
    }
}
