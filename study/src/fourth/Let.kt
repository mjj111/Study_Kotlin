package fourth

/**
 * let 확장 함수도  run 확장 함수와 비슷하게 매게 변수의 타입만 다를 뿐, run과 거의 유사한 역할을 한다.
 * inline fun <T, R> T.let(bloc: (T) -> R): R{ return block(this)}
 * let에서 매개변수로 (T) -> R 타입의 함수를 받는데, 서로 호환되는 ㅏ입이기 떄문에 사실 ru과 let은 표기법만 다를뿐 사실 똑같은 역할을 수행한다.
 *
 */

fun main(args: Array<String>) {
    val a = 10
    val b = 10

    (a*b - 2*a).let{
        result: Int ->
        if (result > 0) println("10보다 큼")
    }
}