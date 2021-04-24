package map

import atomictest.capture
import atomictest.eq

fun main() {
    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )
    constants eq "{Pi=3.141, e=2.718, phi=1.618}"

    constants["e"] eq 2.718
    constants["none"] eq null
    constants["none"] ?: 0 eq 0

    constants.get("e") eq 2.718
    constants.get("none") eq null
    constants.get("none") ?: 0 eq 0

    constants.getOrDefault("none", 0) eq 0
    constants.getOrElse("none") { 0 } eq 0

    constants.getValue("e") eq 2.718
    capture {
        constants.getValue("none")
    } eq "NoSuchElementException: Key none is missing in the map."

    val mutableMap = constants.toMutableMap()
    mutableMap.getOrPut("e") { 0.0 } eq 2.718
    // If there is no key, getOrPut() put the new entry:
    mutableMap.getOrPut("none") { 0.0 } eq 0.0

    constants.keys eq setOf("Pi", "e", "phi")
    constants.values eq "[3.141, 2.718, 1.618]"

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
