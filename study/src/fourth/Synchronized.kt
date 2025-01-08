package fourth

import kotlin.concurrent.thread

/**
 * 코틀린에서는 동기화를 위한 키워드를 따로 제공하지 않는다.
 * 스레드를 동기화하려면 synchronized 함수를 사용해야한다.
 */
private var number: Int = 0

private fun pluseNumber() {
    for (i in 1..1000) {
        synchronized(number) {
            number += 1
        }
    }
}

fun main() {
    thread{ pluseNumber() }
    pluseNumber()
    Thread.sleep(100)
    println(number)
}