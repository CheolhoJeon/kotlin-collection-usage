package list.map

import atomictest.eq

fun main() {
    val x = listOf("123", "abc", "456")

    x.map(String::toIntOrNull).filterNotNull() eq "[123, 456]"
    // More short and readable:
    x.mapNotNull(String::toIntOrNull) eq "[123, 456]"
}
