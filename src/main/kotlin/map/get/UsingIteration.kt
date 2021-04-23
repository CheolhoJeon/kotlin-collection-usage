package map

import atomictest.eq

fun main() {
    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )
    constants eq "{Pi=3.141, e=2.718, phi=1.618}"

    var s = ""
    // Iterate through key-value pairs:
    for (entry in constants) {
        s += "${entry.key}=${entry.value}, "
    }
    s eq "Pi=3.141, e=2.718, phi=1.618,"

    s = ""
    // Unpack during iteration:
    for ((key, value) in constants) {
        s += "$key=$value, "
    }
    s eq "Pi=3.141, e=2.718, phi=1.618,"
}
