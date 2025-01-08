package fourth

import kotlin.concurrent.thread

/**
 * 코틀린에서는 thread 함수를 통해 스레드를 생성할 수 있다.
 * 참고로, thread 함수는 JVM 스레드를 생성하기 때문에, 이 함수를 사용하면 JVM에 의존성이 생긴다.
 *
 */
fun main(args: Array<String>) {
    thread(start = true) {
        println("hello")
        Thread.sleep(1000)
        println("world")
    }

    Thread.sleep(500)
    println("김명준의")
}