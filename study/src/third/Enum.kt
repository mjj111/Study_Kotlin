package third

enum class Mode{
    PEN, ERASER, SHAPE
}
fun main(args: Array<String>) {
    val mode: Mode = Mode.PEN
    when (mode) {
        Mode.PEN -> {println("펜이네")}
        Mode.ERASER -> {println("지우개네")}
        Mode.SHAPE -> {println("도형이네")}
    }
}