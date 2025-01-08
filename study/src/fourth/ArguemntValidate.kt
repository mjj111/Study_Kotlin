package fourth

fun main(args: Array<String>) {
    f1(1)
    f2(1)
}

fun f1(num: Int?) {
    checkNotNull(num)
    check(num >= 10)
}

fun f2(num: Int?) {
    requireNotNull(num)
    require(num < 10)
}