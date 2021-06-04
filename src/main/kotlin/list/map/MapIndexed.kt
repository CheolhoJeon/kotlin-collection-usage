package list.map

import atomictest.eq

fun main() {
    fun combine(index: Int, element: Char) = "[$index: $element]"
    val list = listOf('a', 'b', 'c')

    list.indices.map { "[$it]" } eq listOf("[0]", "[1]", "[2]")

    list.mapIndexed(::combine) eq listOf("[0: a]", "[1: b]", "[2: c]")

    val destination = mutableListOf<String>()
    list.mapIndexedTo(destination, ::combine)
    destination eq listOf("[0: a]", "[1: b]", "[2: c]")
}
