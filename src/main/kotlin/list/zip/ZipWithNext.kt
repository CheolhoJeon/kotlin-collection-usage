package list.zip

import atomictest.eq

fun main() {
    val list = listOf('a', 'b', 'c', 'd')

    list.zipWithNext() eq
        "[(a, b), (b, c), (c, d)]"
    list.zipWithNext { a, b -> "$a$b" } eq
        "[ab, bc, cd]"
}
