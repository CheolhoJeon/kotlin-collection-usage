package list.checking

import atomictest.eq

fun main() {
    val numbers = listOf(-3, -1, 5, 7, 8)

    numbers.any { it > 0 } eq true
    numbers.any { it > 9 } eq false

    numbers.all { it > -8 } eq true
    numbers.all { it > -1 } eq false

    numbers.none { it > 10 } eq true
    numbers.none { it > 0 } eq false
}
