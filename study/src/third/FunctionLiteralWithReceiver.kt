package third

/**
 * 함수 리터럴에 리시버를 적용하여 확장함수처럼 만들 수 있다.
 */

fun main(args: Array<String>) {
    // 확장 함수에 들어갈 코드 블록을 함수 리터럴로 선언
    val makeSure: Int.(left: Int, right: Int) -> Int

    // 확장함수에 들어갈 함수를 대입
    makeSure = { left: Int, right: Int ->
        if(this < left) left
        else if(this > right) right
        else this
    }

    // makeSure은 확장함수로서 동작하며 동작하는 함수는 위에 대입된 함수가 된다.
    println(15.makeSure(20,40))
    println(15.makeSure(0,40))
    println(15.makeSure(4,13))
}