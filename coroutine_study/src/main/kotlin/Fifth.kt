import kotlin.concurrent.thread
import kotlin.coroutines.*

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
//코루틴의 경량 스레드라는 개념은 OS 레벨에서 kernel level Thread, User level thread를 의미하는게 아니라,
//Continuation(콜백 방식)과 Job(Task 단위 실행)으로 기존 JVM 스레드(OS와 가까운)를 최대한 활용하는 방식


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

///**
//     * Dispatches execution of a runnable [block] with a hint to a scheduler whether
//     * this [block] may execute blocking operations (IO, system calls, locking primitives etc.)
//     *
//     * [taskContext] -- concurrency context of given [block].
//     * [tailDispatch] -- whether this [dispatch] call is the last action the (presumably) worker thread does in its current task.
//     * If `true`, then  the task will be dispatched in a FIFO manner and no additional workers will be requested,
//     * but only if the current thread is a corresponding worker thread.
//     * Note that caller cannot be ensured that it is being executed on worker thread for the following reasons:
//     *   * [CoroutineStart.UNDISPATCHED]
//     *   * Concurrent [close] that effectively shutdowns the worker thread
//     */
//    fun dispatch(block: Runnable, taskContext: TaskContext = NonBlockingContext, tailDispatch: Boolean = false) {
//        trackTask() // this is needed for virtual time support
//        val task = createTask(block, taskContext)
//        val isBlockingTask = task.isBlocking
//        // Invariant: we increment counter **before** publishing the task
//        // so executing thread can safely decrement the number of blocking tasks
//        val stateSnapshot = if (isBlockingTask) incrementBlockingTasks() else 0
//        // try to submit the task to the local queue and act depending on the result
//        val currentWorker = currentWorker()
//        val notAdded = currentWorker.submitToLocalQueue(task, tailDispatch)
//        if (notAdded != null) {
//            if (!addToGlobalQueue(notAdded)) {
//                // Global queue is closed in the last step of close/shutdown -- no more tasks should be accepted
//                throw RejectedExecutionException("$schedulerName was terminated")
//            }
//        }
//        val skipUnpark = tailDispatch && currentWorker != null
//        // Checking 'task' instead of 'notAdded' is completely okay
//        if (isBlockingTask) {
//            // Use state snapshot to better estimate the number of running threads
//            signalBlockingWork(stateSnapshot, skipUnpark = skipUnpark)
//        } else {
//            if (skipUnpark) return
//            signalCpuWork()
//        }
//    }

//internal inner class Worker private constructor() : Thread() {
//        init {
//            isDaemon = true
//        }
//
//        // guarded by scheduler lock, index in workers array, 0 when not in array (terminated)
//        @Volatile // volatile for push/pop operation into parkedWorkersStack
//        var indexInArray = 0
//            set(index) {
//                name = "$schedulerName-worker-${if (index == 0) "TERMINATED" else index.toString()}"
//                field = index
//            }
//
//        constructor(index: Int) : this() {
//            indexInArray = index
//        }
//
//        inline val scheduler get() = this@CoroutineScheduler
//
//        @JvmField
//        val localQueue: WorkQueue = WorkQueue()
//
//        /**
//         * Slot that is used to steal tasks into to avoid re-adding them
//         * to the local queue. See [trySteal]
//         */
//        private val stolenTask: ObjectRef<Task?> = ObjectRef()
//
//        /**
//         * Worker state. **Updated only by this worker thread**.
//         * By default, worker is in DORMANT state in the case when it was created, but all CPU tokens or tasks were taken.
//         * Is used locally by the worker to maintain its own invariants.
//         */
//        @JvmField
//        var state = WorkerState.DORMANT
//
//        /**
//         * Worker control state responsible for worker claiming, parking and termination.
//         * List of states:
//         * [PARKED] -- worker is parked and can self-terminate after a termination deadline.
//         * [CLAIMED] -- worker is claimed by an external submitter.
//         * [TERMINATED] -- worker is terminated and no longer usable.
//         */
//        val workerCtl = atomic(CLAIMED)
//
//        /**
//         * It is set to the termination deadline when started doing [park] and it reset
//         * when there is a task. It serves as protection against spurious wakeups of parkNanos.
//         */
//        private var terminationDeadline = 0L
//
//        /**
//         * Reference to the next worker in the [parkedWorkersStack].
//         * It may be `null` if there is no next parked worker.
//         * This reference is set to [NOT_IN_STACK] when worker is physically not in stack.
//         */
//        @Volatile
//        var nextParkedWorker: Any? = NOT_IN_STACK
//
//        /*
//         * The delay until at least one task in other worker queues will  become stealable.
//         */
//        private var minDelayUntilStealableTaskNs = 0L
//
//        private var rngState = Random.nextInt()
//
//        /**
//         * Tries to acquire CPU token if worker doesn't have one
//         * @return whether worker acquired (or already had) CPU token
//         */
//        private fun tryAcquireCpuPermit(): Boolean = when {
//            state == WorkerState.CPU_ACQUIRED -> true
//            this@CoroutineScheduler.tryAcquireCpuPermit() -> {
//                state = WorkerState.CPU_ACQUIRED
//                true
//            }
//            else -> false
//        }
//
//        /**
//         * Releases CPU token if worker has any and changes state to [newState].
//         * Returns `true` if CPU permit was returned to the pool
//         */
//      fun tryReleaseCpu(newState: WorkerState): Boolean {
//            val previousState = state
//            val hadCpu = previousState == WorkerState.CPU_ACQUIRED
//            if (hadCpu) releaseCpuPermit()
//            if (previousState != newState) state = newState
//            return hadCpu
//        }
//
//        override fun run() = runWorker()
//
//        @JvmField
//        var mayHaveLocalTasks = false
//
//        private fun runWorker() {
//            var rescanned = false
//            while (!isTerminated && state != WorkerState.TERMINATED) {
//                val task = findTask(mayHaveLocalTasks)
//                // Task found. Execute and repeat
//                if (task != null) {
//                    rescanned = false
//                    minDelayUntilStealableTaskNs = 0L
//                    executeTask(task)
//                    continue
//                } else {
//                    mayHaveLocalTasks = false
//                }
//                /*
//                 * No tasks were found:
//                 * 1) Either at least one of the workers has stealable task in its FIFO-buffer with a stealing deadline.
//                 *    Then its deadline is stored in [minDelayUntilStealableTask]
//                 * // '2)' can be found below
//                 *
//                 * Then just park for that duration (ditto re-scanning).
//                 * While it could potentially lead to short (up to WORK_STEALING_TIME_RESOLUTION_NS ns) starvations,
//                 * excess unparks and managing "one unpark per signalling" invariant become unfeasible, instead we are going to resolve
//                 * it with "spinning via scans" mechanism.
//                 * NB: this short potential parking does not interfere with `tryUnpark`
//                 */
//                if (minDelayUntilStealableTaskNs != 0L) {
//                    if (!rescanned) {
//                        rescanned = true
//                    } else {
//                        rescanned = false
//                        tryReleaseCpu(WorkerState.PARKING)
//                        interrupted()
//                        LockSupport.parkNanos(minDelayUntilStealableTaskNs)
//                        minDelayUntilStealableTaskNs = 0L
//                    }
//                    continue
//                }
//                /*
//                 * 2) Or no tasks available, time to park and, potentially, shut down the thread.
//                 * Add itself to the stack of parked workers, re-scans all the queues
//                 * to avoid missing wake-up (requestCpuWorker) and either starts executing discovered tasks or parks itself awaiting for new tasks.
//                 */
//                tryPark()
//            }
//            tryReleaseCpu(WorkerState.TERMINATED)
//        }