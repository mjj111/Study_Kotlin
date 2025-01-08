package fourth

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    println(measureTimeMillis {
        var sum = 0L
        for(i in 1.. 1000000) sum += i
    })

    println(measureNanoTime {
        var sum = 0L
        for(i in 1.. 1000000) sum += i
    })
}