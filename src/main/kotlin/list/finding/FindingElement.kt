package list.finding

import atomictest.eq

fun main() {
    val list = listOf(-8, -3, 0, 2, 9)

    // find() == first():
    list.find { it > 0 } eq 2
    list.first { it > 0 } eq 2

    // findLast() == last():
    list.findLast { it > 0 } eq 9
    list.last { it > 0 } eq 9
}
