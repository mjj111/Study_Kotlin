package second

/**
 * 예외란, 프로그램 실행 중 예상치 못하게 발생한 상황을 뜻한다.
 * 기본적으로 프로그램은 예외가 발생하면 오류 메시지와 함께 종료되는데,
 * 이를 처리하여 프로그램의 강제 종료를 막을 수 있다.
 * 또한, 예외를 던질 수도 있다.
 */

class CustomException(message: String) : Throwable(message)

fun main(args: Array<String>) {
    try {
        val str = "ab"
//        val num = str.toInt() // NumberFormatException 발생
        throw CustomException("고의적 예외") // CustomException 던지기
        println(str) // 이 코드는 실행되지 않음
    } catch (e: NumberFormatException) {
        println(e.message)
    } catch (e: CustomException) { // CustomException 처리
        println("커스텀 고의 예외" + e.message)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("프로그램은 수행하고 예외는 처리 되었다.")
    }
}