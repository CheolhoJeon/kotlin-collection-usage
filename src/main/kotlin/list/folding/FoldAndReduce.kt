package list.folding

import atomictest.eq

fun main() {
    /* Simple Usage */
    val numbers = listOf(10, 100, 1000)
    fun sum(x: Int, y: Int) = x + y

    numbers.fold(1, ::sum) eq 1111
    numbers.reduce(::sum) eq 1110

    /* runningFold(), runningReduce() */
    numbers.runningFold(1, ::sum) eq "[1, 11, 111, 1111]"
    numbers.runningReduce(::sum) eq "[10, 110, 1110]"

    /* foldRight(), reduceRight() */
    val chars = "A B C D".split(" ")
    fun combine(acc: String, element: String) = "$acc $element"

    chars.fold("X", ::combine) eq "X A B C D"
    chars.foldRight("X", ::combine) eq "A B C D X"
    chars.reduce(::combine) eq "A B C D"
    chars.reduceRight(::combine) eq "A B C D"
}
