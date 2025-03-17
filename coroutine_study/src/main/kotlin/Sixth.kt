import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.logging
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import kotlin.system.measureTimeMillis

/**
1000번 요청에 약 3초 소요

Dispatcher.DEFALUT 하나로 두개의 작업 동시성 확보 Execution Time: 3065 ms
Dispatcher.IO로 작업에 따라 thread 할당 Execution Time: 2989 ms
사실상 MVC를 사용하면 request에 하나의 스레드가 묶이기 때문에 delay(500)으로 계산하면 거의 딱 맞춰 떨어진다.
주어진 스레드에서 동시성을 가지던, IO로 시키던 큰 차이는 없음을 확인했다.
(webFlux쓰면 얼마나 빨라질까.. 궁금하네)
 */


fun main() {

    // 톰캣 기본 스레드풀 크기 200에 맞춰, 스레드 풀을 생성
    val TOMCAT_THREADPOOL_SIZE = 200
    val threadFactory = ThreadFactory { r -> Thread(r, "TomcatPool-${r.hashCode()}") }
    val executorService = Executors.newFixedThreadPool(TOMCAT_THREADPOOL_SIZE, threadFactory)

    val time = measureTimeMillis {
        val tasks = mutableListOf<java.util.concurrent.Future<*>>()

        // 1,000번 작업 세팅
        repeat(1_000) {
            val future = executorService.submit { chatServiceDoing() }
            tasks.add(future)
        }

        // 모든 작업이 종료될 때까지 대기
        tasks.forEach { it.get() }
    }

    println("\nExecution Time: $time ms")

    executorService.shutdown()
}

fun chatServiceDoing() {
    runBlocking {
        launch(Dispatchers.IO){ saveToDB() }
        launch(Dispatchers.IO){ notificationWithFCM() }
    }
}
suspend fun saveToDB() {
    logging("db 저장")
    delay(500)
}

suspend fun notificationWithFCM(){
    logging("알림 전달")
    delay(500)
}