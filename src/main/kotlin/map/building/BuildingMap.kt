package map

import atomictest.eq

fun main() {
    /* Building 'immutable map' by mapOf() */
    val constants: Map<String, Double> = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
    )
    constants eq "{Pi=3.141, e=2.718}"
    //constants += "phi" to 1.618

    /* Building 'mutable map' by mutableMapOf() */
    val numbers: MutableMap<Int, String> = mutableMapOf(
        5 to "five",
        6 to "six",
    )
    numbers eq "{5=five, 6=six}"
    numbers += 7 to "Seven"
}
