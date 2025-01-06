/**
 * 코틀린에서는 @outer 이라고하는 레이블이 있다.
 * 해당 문법을 사용하면 break@outer 사용시,
 * outer@ while이 선언된 반복문을 탈출하게 된다.
 * Java 에서는 해당 break문을 만나기전 반복문을 깨지만,
 * 해당 코틀린의 레이블을 사용하게 되면 굳이 변수를 추가할 필요없이 원하는 반복문을 탈출 할 수 있게된다.
 */
fun main(args: Array<String>) {
    var a = 15
    var b = 15

    if(a > b) {
        println("if문 true 실행")
    } else if(a < b) {
        println("else if 문 실행")
    } else{
        println("if문 else 시행")
    }

    while(a >= b) {
        b--
    }
    println(b) //2147483647
    println(Int.MAX_VALUE) //2147483647
    do {
        b++
    }while(a > b && b < 10)

    when(a > b) {
        true -> {println("true 결과")}

        false -> {println("false 결과")}
    }

    println(b)//10

    for (i in 0 until 10) {
        println(1)
    }
}