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

    constants.getValue("e") eq 2.718
    capture {
        constants.getValue("none")
    } eq "NoSuchElementException: Key none is missing in the map."
}
