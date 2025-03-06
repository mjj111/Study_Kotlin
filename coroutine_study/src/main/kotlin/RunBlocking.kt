package org.example

import kotlinx.coroutines.*
import java.time.LocalDateTime

fun main(){
    runBlocking { finalQuestion2() }
}

fun logging(msg: String) {
    println("${Thread.currentThread().name} - ${LocalDateTime.now()} : $msg")
}

fun question1(){
    logging("1")
    runBlocking {
        logging("2")
    }
    logging("3")
}

fun question2(){
    logging("1")
    question2_2()
    logging("3")
}

fun question2_2(){
    runBlocking {
        logging("2")
    }
}

suspend fun question3(){
    logging("1")
    CoroutineScope(Dispatchers.IO).launch {
        logging("2")
        delay(2000)
        logging("3")
    }
    logging("4")
    delay(2500)
}

suspend fun question4(){
    logging("1")
    withContext(Dispatchers.IO){
        logging("2")
        delay(1000)
        logging("3")
    }
    logging("4")
    delay(100)
}

suspend fun question5(){
    logging("1")
    GlobalScope.async {
        logging("2")
        delay(1000)
        logging("3")
    }
    logging("4")

    delay(1500)
}

suspend fun question6(){
    logging("1")
    GlobalScope.async {
        logging("2")
        delay(1000)
        logging("3")
    }.join()
    logging("4")

    delay(1500)
}

suspend fun question7(){
    logging("1")
    val job = GlobalScope.launch(start = CoroutineStart.LAZY){
        logging("2")
    }
    delay(200)
    logging("3")
    job.start()
}

suspend fun question8(){
    logging("1")
    val job = GlobalScope.launch(start = CoroutineStart.LAZY){
        delay(200)
        logging("2")
    }
    delay(500)
    logging("3")
    job.start()
}

fun question9(){
    logging("1")
    runBlocking {
        logging("2")
        launch {
            logging("3")
            delay(1000)
            logging("4")
        }
        logging("5")
    }
    logging("6")
}

fun question10(){
    logging("1")
    runBlocking {
        logging("2")
        GlobalScope.launch {
            logging("3")
            delay(1000)
            logging("4")
        }
        logging("5")
    }
    logging("6")
}

suspend fun question11(){
    logging("1")
    GlobalScope.launch {
        logging("2")
        runBlocking {
            logging("3")
            delay(1000)
            logging("4")
        }
        logging("5")
    }
    logging("6")
    delay(2000)
}

suspend fun question12() {
    logging("1")
    runBlocking {
        logging("2")
        val lazyJob = launch(start = CoroutineStart.LAZY) {
            logging("3")
            delay(200)
            logging("4")
        }
        val normalJob = launch {
            logging("5")
            lazyJob.start()
            delay(400)
            logging("6")
        }
        logging("7")
    }
    logging("8")
    delay(1000)
}

suspend fun question13() {
    logging("1")
    runBlocking {
        logging("2")
        val lazyJob = launch(start = CoroutineStart.LAZY) {
            logging("3")
            delay(400)
            logging("4")
        }
        coroutineScope {
            logging("5")
            lazyJob.start()
            delay(200)
            logging("6")
        }
        logging("7")
    }
    logging("8")
    delay(1000)
}

suspend fun question14() {
    logging("1")
    runBlocking {
        logging("2")
        val lazyJob = launch {
            logging("3")
            delay(200)
            logging("4")
        }
        withContext(Dispatchers.IO) {
            logging("5")
            delay(400)
            logging("6")
        }
        logging("7")
    }
    logging("8")
    delay(1000)
}

suspend fun question15() {
    logging("1")
    runBlocking {
        logging("2")
        val lazyJob = GlobalScope.launch(start = CoroutineStart.LAZY) {
            logging("3")
            coroutineScope {
                delay(600)
                logging("4")
            }
            delay(200)
            logging("5")
        }
        coroutineScope {
            logging("6")
            lazyJob.start()
            delay(400)
            logging("7")
        }
        logging("8")
    }
    logging("9")
    delay(1000)
}

fun finalQuestion1() {
    runBlocking {
        logging("1")

        launch {
            logging("2")
            delay(1000L)
            logging("3")
        }

        logging("4")
        withContext(Dispatchers.IO) {
            logging("5")
            Thread.sleep(2000L)
            logging("6")
        }

        logging("7")

        runBlocking {
            logging("8")
            Thread.sleep(2000L)
            logging("9")
        }

        withContext(Dispatchers.IO) {
            logging("10")
            delay(1000L)
            logging("11")
            withContext(Dispatchers.IO) {
                logging("12")
                delay(1000L)
                logging("13")
            }
            logging("14")
        }
        logging("15")
    }

    GlobalScope.launch {
        logging("16")
        delay(1000L)
        logging("17")
    }

    runBlocking {
        logging("18")
    }
}

suspend fun finalQuestion2(){
    logging("1")
    val normalJob = GlobalScope.launch {
        logging("2")
        delay(200)
        logging("3")
    }
    runBlocking {
        logging("4")
        val lazyJob  = GlobalScope.launch(start = CoroutineStart.LAZY) {
            logging("5")
            delay(600)
            logging("6")
        }
        withContext(Dispatchers.IO) {
            logging("7")
            lazyJob.start()
            delay(400)
            logging("8")
        }
        val innerNormalJob = GlobalScope.launch {
            logging("9")
            delay(800)
            logging("10")
        }
        logging("11")
    }
    logging("12")
    delay(2000)
}