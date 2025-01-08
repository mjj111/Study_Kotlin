package fourth

/**
 * Collection, Map에서 살펴본 인터페이스들은 원소를 추가하거나 삭제하는 멤버함수가 없었다.
 * 이는 Collection 인터페이스는 컬렉션 원소를 수정할 수 있는 방법을 제공하지 않는다.
 * 원소를 수정하려면 MutableCollection 인터페이스를 구현하는 컬렉션을 이용해야한다.
 *
 * MutableCollection은 Collection과 MutableIterable을 상속한다.
 * MutableIterable은 add(), addAll(), remove(), removeAll(), retainAll(), clear()을 갖는다.
 *
 * MutableListIterator 인터페이스는 ListIterator과 MutableIterator 인터페이스를 구현한다.
 *
 * MutableList는 MutableCollection, MutableListIterator을 상속하며
 * add(index, element), addAll(), set(), removeAt 을 추가로 갖고있다.
 *
 * MutableSet은 MutableCollection을 상속하고 따로 추가된 멤버는 없다.
 *
 * MutableMap은 Map<K,V>를 상속한다. 기존에 있던 Map의 멤버함수를 오버라이딩한다.
 * setValue(newValue: V): V
 *
 */

