import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.logging
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

//Dispatcher.DEFALUT 하나로 두개의 작업 동시성 확보 Execution Time: 3982 ms(요청 1만) 24423 ms(요청 10만)
//Dispatcher.IO로 작업에 따라 thread 할당 Execution Time: 4370 (요청 1만) 26870ms (요청 1만)

fun main() {
    logging("main에서 실행된 스레드")
    val time = measureTimeMillis {
        val threads = ConcurrentLinkedQueue<Thread>()

        repeat(100000) {
            val t = thread {
                runBlocking {
                    launch { saveToDB() }
                    launch { notifiactionWithFCM() }
//                    launch(Dispatchers.IO) { saveToDB() }
//                    launch(Dispatchers.IO) { notifiactionWithFCM() }
                }
            }
            threads.add(t)
        }

        threads.forEach { it.join() }
    }

    println("\nExecution Time: $time ms")
}

// 추가적인 IO 스레드를 생성하지 않고 현재 스레드만으로 동시성을 갖도록 하려면 지금과 같은 방법이 좋을 듯 하다.
// SpringMVC 를 쓰고 있다면... 지금이 모양새가 좋지 않을까? (request하나에 하나의 스레드가 동작하고 있으니 어차피 해야할 거)
// 이런식으로 외부 리소스에 접근할 경우,
// 다른 thread(Dispatcher.IO와 같은)를 생성하거나 풀을 쓰기보다는 현재 사용하는 스레드로 동시성을 확보하는게 좋아보이는데..흠
// DispatcherIO를 쓰는게 좋으려나.. 부하가 생기면 어떨지 더 테스트가 필요해보인다. (WebFlux 궁금해지네..)


suspend fun saveToDB() {
    logging("db 저장")
    delay(1000)
}

suspend fun notifiactionWithFCM(){
    logging("알림 전달")
    delay(1000)
}
