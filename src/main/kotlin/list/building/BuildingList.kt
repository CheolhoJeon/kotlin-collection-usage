package list.building

import atomictest.eq

fun main() {
    /* You can hold various data types in List */
    listOf(1, 2, 3) eq "[1, 2, 3]"
    listOf("one", "two", "three") eq "[one, two, three]"

    /* Immutable List & Mutable List */
    val mutableList = mutableListOf(1)
    mutableList.add(2)
    mutableList eq "[1, 2]"
    val immutableList = listOf(1)
    // Immutable list can't be added
    // But if identifier is declared 'var', Kotlin'd create and reassign new list:
    // immutableList.add(2)

    /* Using List() */
    // The lambda argument is the element index:
    List(10) { it } eq "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"
    List(10) { 0 } eq "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]"
    List(10) { 'a' + it } eq "[a, b, c, d, e, f, g, h, i, j]"
    List(10) { listOf('a', 'b', 'c', 'd')[it % 3] } eq
        "[a, b, c, a, b, c, a, b, c, a]"
    MutableList(10) { it } eq "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"
}
