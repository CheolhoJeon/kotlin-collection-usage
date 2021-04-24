package map

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
}
