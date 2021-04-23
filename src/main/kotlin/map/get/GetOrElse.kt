package map

import atomictest.eq

fun main() {
    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )
    constants eq "{Pi=3.141, e=2.718, phi=1.618}"

    constants.getOrElse("e") { 0 } eq 2.718
    constants.getOrElse("none") { 0 } eq 0
}
