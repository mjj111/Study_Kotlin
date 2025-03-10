package org.example
import kotlinx.coroutines.*
import java.time.LocalDateTime
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            repeat(50_000) {
                launch {
                    print(".")
                }
            }
        }
    }
    println("\nExecution Time: $time ms")
}

fun logging(msg: String) {
    println("${Thread.currentThread().name} - ${LocalDateTime.now()} : $msg")
}

suspend fun doWorld() {
    coroutineScope {
        launch {
            delay(1000L)
            logging("World!")
        }
        logging("Hello")
    }
}

