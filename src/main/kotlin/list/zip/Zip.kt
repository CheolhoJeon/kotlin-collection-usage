package list.zip

import atomictest.eq

data class Person(
    val name: String,
    val id: Int
)

fun main() {
    // Simple Example:
    val left = listOf("a", "b", "c", "d")
    val right = listOf("q", "r", "s", "t")

    left.zip(right) eq
        "[(a, q), (b, r), (c, s), (d, t)]"
    left.zip(0 until 4) eq
        "[(a, 0), (b, 1), (c, 2), (d, 3)]"
    (10..100).zip(right) eq
        "[(10, q), (11, r), (12, s), (13, t)]"

    // Person Example:
    val names = listOf("Bob", "Jill", "Jim")
    val ids = listOf(1731, 9274, 8378)
    names.zip(ids) { name, id ->
        Person(name, id)
    } eq
        "[Person(name=Bob, id=1731), " +
        "Person(name=Jill, id=9274), " +
        "Person(name=Jim, id=8378)]"

    names.zip(ids, ::Person) eq
        "[Person(name=Bob, id=1731), " +
        "Person(name=Jill, id=9274), " +
        "Person(name=Jim, id=8378)]"
}
