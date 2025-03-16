import kotlin.concurrent.thread
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.intrinsics.createCoroutineUnintercepted
import kotlin.coroutines.intrinsics.intercepted

//  1. Dispatcher: 비동기 실행을 위한 스레드 관리
interface Dispatcher {
    fun dispatch(block: () -> Unit)
}

object DefaultDispatcher : Dispatcher {
    override fun dispatch(block: () -> Unit) {
        thread { block() } // 새로운 스레드에서 실행
    }
}

// 2. CoroutineScope: 코루틴 실행을 위한 범위
interface CoroutineScope {
    fun launch(block: suspend CoroutineScope.() -> Unit): Job
}

// 3. Job: 코루틴의 실행 상태 관리
class Job {
    private var isActive = true

    fun cancel() {
        isActive = false
    }

    fun isActive(): Boolean = isActive
}

// 4. SimpleCoroutineScope: 코루틴 실행 및 관리
class SimpleCoroutineScope(private val dispatcher: Dispatcher) : CoroutineScope {
    override fun launch(block: suspend CoroutineScope.() -> Unit): Job {
        val job = Job()

        // 주어진 dispacher를 통해, 스레드에게 할일을 전달
        // Coroutine을 생성 및 비동기적으로 실행
        dispatcher.dispatch {
            val continuation = block.createCoroutine(this, object : Continuation<Unit> {
                override val context: CoroutineContext = EmptyCoroutineContext
                override fun resumeWith(result: Result<Unit>) {
                    result.onFailure { it.printStackTrace() }
                }
            })
            continuation.resume(Unit)
        }

        return job
    }
}

// 5. suspend 함수: Continuation을 사용해 비동기 실행
suspend fun mySuspendFunction() = suspendCoroutine<Unit> { continuation ->
    println("Suspending... (현재 스레드: ${Thread.currentThread().name})")
    DefaultDispatcher.dispatch {
        println("Resuming... (현재 스레드: ${Thread.currentThread().name})")
        continuation.resume(Unit) // 실행 재개
    }
}

// 6. 실행 예제
fun main() {
    val scope = SimpleCoroutineScope(DefaultDispatcher)

    scope.launch {
        println("Coroutine started! (현재 스레드: ${Thread.currentThread().name})")
        mySuspendFunction() // suspend 함수 호출 (일시 중단 후 재개)
        println("Coroutine finished! (현재 스레드: ${Thread.currentThread().name})")
    }

    Thread.sleep(2000) // 메인 스레드 종료 방지
}
//(Main Thread) launch 실행 → Dispatcher를 통해 새 스레드에서 코루틴 실행.
//(New Thread) Continuation을 만들어 실행을 관리.
//(Main Thread) mySuspendFunction() 실행 → suspendCoroutine으로 일시 중단.
//(New Thread) dispatcher.dispatch {}로 새로운 스레드에서 실행 재개.
//(New Thread) 실행이 재개되고 Coroutine finished! 출력.

//@SinceKotlin("1.3")
//@Suppress("UNCHECKED_CAST")
//public fun <R, T> (suspend R.() -> T).createCoroutine(
//    receiver: R,
//    completion: Continuation<T>
//): Continuation<Unit> =
//    SafeContinuation(createCoroutineUnintercepted(receiver, completion).intercepted(), COROUTINE_SUSPENDED)
