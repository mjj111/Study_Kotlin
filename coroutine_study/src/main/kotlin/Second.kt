package org.example

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

suspend fun main() {
    runJob2()
}

suspend fun runJob1() {
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

suspend fun runJob2() {

    val startTime = System.currentTimeMillis()
    val job = coroutineScope {
        launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
    }

    delay(1300L)
    println("main: 기다리다 지쳤어요 작업 취소할게요~!")
    job.cancelAndJoin()
    println("main: 멈췄어요! ")
}

//CoroutineContext?
//LazyStandaloneCoroutine?
//continution?

//public fun CoroutineScope.launch(
//    context: CoroutineContext = EmptyCoroutineContext,
//    start: CoroutineStart = CoroutineStart.DEFAULT,
//    block: suspend CoroutineScope.() -> Unit
//): Job {
//    val newContext = newCoroutineContext(context)
//    val coroutine = if (start.isLazy)
//        LazyStandaloneCoroutine(newContext, block) else
//        StandaloneCoroutine(newContext, active = true)
//    coroutine.start(start, coroutine, block)
//    return coroutine
//}
