package list.filter

import atomictest.eq

/**
 * [filterNotNull()]은 컬렉션에 저장된 요소 중 null이 아닌 값만 필터링한다.
 * 즉, null 값을 제외시킨다.
 */
fun main() {
    val list = listOf(1, 2, null)
    list.filterNotNull() eq "[1, 2]"
}
