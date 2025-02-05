package third

/**
 * 람다식으로된 함수 리터럴을 아래와 같이 익명함수 형태로 바꿀 수 있다.
 * 익명 함수는 하뭇의 이름이 없다는 점만 빼면, 일반 함수와 형태가 거의 동일하다.
 *
 * 익명 함수는 람다보다 복잡하지만, return으로 반환 값을 직접 지정해줄 수 있기 때문에,
 * 마지막 표현식이 자동으로 반환 값이 되어버리는 람다식보다 버그를 일으킬 확률이 적다.
 */
fun main(args: Array<String>) {
    val instantFunc: (Int) -> Unit = fun(number: Int): Unit {
        println(number)
    }

    instantFunc(5)
    instantFunc.invoke(33)
}