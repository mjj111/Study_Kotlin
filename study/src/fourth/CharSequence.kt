package fourth

/**
 * CharSequence는 String, StringBuilder등 문자열과 관련된 클래스들이 구현하는 기본적인 뼈대 인터페이스다.
 * 이름상으로는 CharSequence가 Sequence를 상속할 것 같지만 사실은 어떠한 인터페이스도 상속하고 있지 않는다.
 *
 * CharSequence 는 하나릐 프로퍼티와 두 개의 멤버 함수를 갖고 있다.
 * length, get, subSequence
 * startsWith, endsWith..
 * removePrefix..
 * isEmpty, isBlank, isNullOrEmpty..
 * trim, slice, subSequence,subString, reserved
 * lines, lineSequence
 *
 * 참고로 String은 Comparable과 CharSequence 인터페이스를 구현하며 plus 멤버를 추가적으로 가진다.
 * replace
 */