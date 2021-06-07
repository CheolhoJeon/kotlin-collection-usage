package list

import atomictest.eq

data class Student(
    val name: String,
    val score: Int
)

fun Student.isPassed() = score >= 80

fun main() {
    val students = listOf(
        Student("Charlie", 70),
        Student("Alice", 82),
        Student("Bob", 42),
        Student("Mike", 95),
    )

    val passed = students.filter(Student::isPassed)
    val notPassed = students.filterNot(Student::isPassed)

    passed.map(Student::name) eq "[Alice, Mike]"
    notPassed.map(Student::name) eq "[Charlie, Bob]"

    val (pos, neg) = students.partition(Student::isPassed)
    pos eq passed
    neg eq notPassed
}
