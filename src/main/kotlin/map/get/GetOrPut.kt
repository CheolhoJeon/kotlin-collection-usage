package map

import atomictest.eq

fun main() {
    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )
    constants eq "{Pi=3.141, e=2.718, phi=1.618}"

    // Map doesn't have getOrPut() function
    //constants.getOrPut("e") { 0.0 } eq 2.718

    val mutableMap = constants.toMutableMap()
    mutableMap.getOrPut("e") { 0.0 } eq 2.718
    // If there is no key, getOrPut() put the new entry:
    mutableMap.getOrPut("none") { 0.0 } eq 0.0
}
