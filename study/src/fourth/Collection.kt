package fourth

/**
 * 컬렉션이란 프로그래밍에서 필요한 기본적인 자료구조를 통칭하는 말이다.
 * 코틀린에는 List, Set Map 크게 세가지가 있다.
 * List와 Set은 Collection 인터페이스를 상속하고 Map은 상속하지 않는다.
 * 그렇기 때문에, List와 Set은 공통의 멤버를 갖지만, Map은 독자적인 멤버를 갖는다.
 *
 * Collection 인터페이스는 size, isEmpty(), contains(), containsAll(), iterator() 들이 있다.
 * List 인터페이스는 get(), indexOf(), lastIndexOf(), listIterator(), subList()들이 있다.
 * Map 인터페이스는 Entry인터페이스, size, keys: Set<K>, values: Collection<V>, entries: Set<Map.Entry<K, V>>
 *     isEmpty(), containsKey(), containsValue(), get(), getOrDefault() 들이 있다.
 */

fun main(args: Array<String>) {
    val list: Collection<Int> = listOf(10, 20)
    val set: Collection<Int> = setOf(1, 2, 3)
    val map: Map<Int, Int> = mapOf(1 to 10, 2 to 20, 3 to 30)

    println(map)
}