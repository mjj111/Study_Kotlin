package third

import kotlin.reflect.KProperty

/**
 * 위임된 프로퍼티란?
 * 프로그래밍 중, Int 타입의 프로퍼티에 음수가 저장되는것을 방지하는 Setter을 정의할 때가 자주있다.
 * 그러나 모든 프로퍼티에 모두 Setter을 일일이 정의하는 것은 너무 번거로운데,
 * 코틀린은 이러한 상황을 위해 Getter/Setter 구현을 다른 객체에 맡길 수 있는 문법을 제공한다.
 */

class Sample{
    var number: Int by OnlyPositive()
}

/**
 * 프로퍼티를 대리하는 객체는 아래와같은 멤버함수를 갖고 있어야한다.
 * 여기서 T는 대리할 프로퍼티의 타입이다.
 * Sample클래스의 number 프로퍼티의 Getter은 getValue, Setter은 OnlyPositive의 setValue로 대체된다.
 */
class OnlyPositive {
    private var realValue: Int = 0

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return realValue
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        realValue = if(value > 0) value else 0
    }
}