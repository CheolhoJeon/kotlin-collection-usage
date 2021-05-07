package list.folding

import atomictest.eq

class Condition<T>(val check: (T) -> Boolean)

fun <T> Condition<T>.combine(other: Condition<T>) = Condition<T> { check(it) && other.check(it) }

fun <T> List<Condition<T>>.combineAll(): (T) -> Boolean =
    reduce(Condition<T>::combine).check

fun main() {
    data class Person(val name: String, val age: Int, val sex: String) {
        fun isMale() = sex == "Male"
        fun isFemale() = sex == "Female"
    }

    val persons = listOf(
        Person("Bob", 13, "Male"),
        Person("Alice", 10, "Female"),
        Person("Charlie", 43, "Male"),
    )
    val predicates = listOf(
        Condition(Person::isMale),
        Condition { it.age > 10 }
    ).combineAll()

    persons.count(predicates) eq 2
    persons.filter(predicates) eq "[Person(name=Bob, age=13, sex=Male), Person(name=Charlie, age=43, sex=Male)]"
    persons.any(predicates) eq true
    persons.all(predicates) eq false
}
