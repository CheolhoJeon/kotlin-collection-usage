package list

import atomictest.eq

fun main() {
    val intRange = 1..3

    intRange.map { a ->
        intRange.map { b -> a to b }
    } eq "[" +
        "[(1, 1), (1, 2), (1, 3)], " +
        "[(2, 1), (2, 2), (2, 3)], " +
        "[(3, 1), (3, 2), (3, 3)]" +
        "]"

    intRange.map { a ->
        intRange.map { b -> a to b }
    }.flatten() eq "[" +
        "(1, 1), (1, 2), (1, 3), " +
        "(2, 1), (2, 2), (2, 3), " +
        "(3, 1), (3, 2), (3, 3)" +
        "]"

    // map() + flatten() == flatMap():
    intRange.flatMap { a ->
        intRange.map { b -> a to b }
    } eq "[" +
        "(1, 1), (1, 2), (1, 3), " +
        "(2, 1), (2, 2), (2, 3), " +
        "(3, 1), (3, 2), (3, 3)" +
        "]"
}
