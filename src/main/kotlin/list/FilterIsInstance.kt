package list

import atomictest.eq

interface Creature
class Human : Creature
class Bird : Creature
class Dog : Creature

fun Dog.bark() = "Yip!"

val group: List<Creature> = listOf(
    Human(), Human(), Dog(), Bird(), Dog()
)

fun main() {
    val dog = group.find { it is Dog } as Dog?
    dog?.bark() eq "Yip!"

    val creaturesWhoIsHuman: List<Creature> =
        group.filter { it is Human }

    val humans1: List<Human> =
        group.filterIsInstance<Human>()
    creaturesWhoIsHuman eq humans1

    val humans2: List<Human> =
        group.filterIsInstance(Human::class.java)
    humans1 eq humans2
}
