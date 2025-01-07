package third

/**
 * 코틀린에서는 상속에 의한 다이아몬드 문제에서 부모의 멤벼 함수를 호출해야할 때,
 * 선택할 수 있도록 해준다.
 */
interface Parents {
    fun follow(): Unit
}

interface Mother: Parents {
    override fun follow() = println("Following Mother")
}

interface Father: Parents {
    override fun follow() = println("Following Father")
}

class Child: Mother, Father {
    override fun follow() {
        println("Child doing follow")
        super<Mother>.follow()
    }
}

fun main(args: Array<String>) {
    Child().follow()
}