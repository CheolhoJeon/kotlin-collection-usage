package list.joinToString

import atomictest.eq

fun main() {
    val list = listOf(9, 11, 23, 32)
    list.joinToString(" ") { "[$it]" } eq
        "[9] [11] [23] [32]"

    // Default value of [prefix] and [postfix] is "":
    list.joinToString(prefix = "[first] ", postfix = " [last]", separator = " ") { "[$it]" } eq
        "[first] [9] [11] [23] [32] [last]"

    // Default value of [separator] is ", ":
    list.joinToString() { "$it" } eq
        "9, 11, 23, 32"

    // If the number of element is bigger than [limit],
    // else elements are skipped and truncated is placed in last of string
    list.joinToString(limit = 3, truncated = "...") eq
        "9, 11, 23, ..."

    // You don't need to use joinTo()
    // because StringBuffer is used in joinToString():
}
