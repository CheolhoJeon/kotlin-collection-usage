package list.zip

import atomictest.capture
import atomictest.eq
import kotlin.random.Random

fun main() {
    val characters = listOf('A', 'B', 'C')
    // Result of random() can't be predicted because it would be random!!:
    // characters.random() eq ???

    // We fixed a random seed. Therefore the result can be predicated:
    characters.random(Random(17)) eq 'C'

    val empty = listOf<Char>()
    capture {
        empty.random()
    } eq "NoSuchElementException: Collection is empty."
    empty.randomOrNull() eq null
    empty.randomOrNull(Random(17)) eq null
}
