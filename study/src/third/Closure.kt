package third

/**
 * 로컬 변수는 자신이 소속된 블록이 끝나면 소멸하지만,
 * 클로저라는 것을 이용하여 로컬 변수가 소멸하지 않는 것 처럼 보이게 할 수 있다.
 * 함수 리터럴이 본인이 만들어질 때 상황을 기억하고 있기 때문에 매개 변수의 값을 복사해서 갖고 있는다.
 * 이러한 함수를 클로저(Closure)라고 부른다.
 */

fun AA(number: Int): () -> Unit = {println(number)}

fun main(args: Array<String>) {
    val f: () -> Unit = AA(30)
    f()
}