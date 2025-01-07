package first

/**
 * 코틀린은 비트연산을 특이하게도 기호가 아닌 문자로 되어있다.
 * and or xor inv
 * shl (shift left) shr (shift right)
 * ushr(부호 유지하고 시프트)
 */
fun main(args: Array<String>) {
    println(15 and 7)
    println(5 or 2)
    println(421.inv())
    println(1 shl 3)
    println(8 shr 1)
    println(-17 ushr 2)
}