package second

/**
* 문자열간의 덧셈 연산은 힙 영역에 계속해서 공간을 차지하게 만든다.
 * hello와 world 가 더 해지면,
 * fitst는 hello world 문자열을 참조하게되고,
 * hello는 참조하지 않지만 힙영역에서 머무르게 된다.
 *
 * 이 경우, 언제인지 확신할 수 는 없지만 미아 객체가 많이 쌓이면,
 * 적당한 시점에서 시스템이 자동으로 가비지 컬렉션을 수행하여 쓰레기 객체를 수거해간다.
 * 참고로, 가바지 컬렉션이 일어날 때는 삭제해야할 미아 객체를 탐색해야하기 때문에 , stop the world -> Freezing 이 일어날 수 있다.
 *
 */
fun main(args: Array<String>) {
    var first = "hello"
    var second = " world"
    first = first + second
    println(first)
}