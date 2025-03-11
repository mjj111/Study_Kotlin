package org.example

import kotlinx.coroutines.*

suspend fun main() {

    val job = CoroutineScope(Dispatchers.IO).launch {
        repeat(1000) { i ->
            println("job: 잠깐 잠 좀 잘게요 $i ...")
            delay(500L)
        }
    }

    delay(1300L)

    println("main: 기다리다 지쳤어요 작업 취소할게요~!")

    job.cancel()
    job.join()

    println("main: 멈췄어요! ")
}
