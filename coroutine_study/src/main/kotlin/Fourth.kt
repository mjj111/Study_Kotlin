package org.example

import kotlinx.coroutines.*

fun main(){
    runBlocking {
        launch {
            logging("1")
            //main - 2025-03-16T00:02:03.997624900 : 1
        }

        launch(Dispatchers.Default) {
            logging("2")
            //DefaultDispatcher-worker-1 - 2025-03-16T00:02:03.981176900 : 2
        }
        launch(Dispatchers.Unconfined) {
            logging("3")
            //main - 2025-03-16T00:02:03.981176900 : 3
        }

        launch(Dispatchers.IO) {
            logging("4")
            //DefaultDispatcher-worker-1 - 2025-03-16T00:02:03.997624900 : 4
        }
    }
}