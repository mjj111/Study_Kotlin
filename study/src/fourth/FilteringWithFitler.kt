package fourth

/**
 * filter계열의 확장 함수를 이용하면, 컬렉션 중 원하는 원소만 걸러낼 수 있다.
 * filter, filterNot, filterNotNull
 * filterIndexed, filterIsInstance<T>
 */

fun main(args: Array<String>) {
    val to50 = 1..50

    //true 인 값들만 남는다.
    println(to50.filter {it % 2 == 0})
}