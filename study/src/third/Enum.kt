package third

/**
 * 참고로 열거 클래스는 자바와 매우 비슷하며,
 * valueOf(value: String): 열거 클래스
 * values():Array<열거 클래스>
 *  위 멤버 함수들이 기본적으로 포함되어있다 .
 */
enum class Mode(val number: Int){
    PEN(0), ERASER(1), SHAPE(2)
}
fun main(args: Array<String>) {
    val mode: Mode = Mode.PEN
    when (mode) {
        Mode.PEN -> {println("펜이네")}
        Mode.ERASER -> {println("지우개네")}
        Mode.SHAPE -> {println("도형이네")}
    }
    println(mode.number)
    println(Mode.valueOf("PEN").number)
    println(Mode.values()[mode.number])
}