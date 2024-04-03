package ru.ilyamnl.homework

import java.time.LocalDate

fun main() {

    val amp1 = mapOf<Int, Int>()

    val amp2 = mapOf(
        "One" to 1,
        "Two" to 2,
        "Three" to 3
    )

    val amp3 = mutableMapOf<Int, String>().also { map ->
        map[1] = "One"
        map[2] = "Two"
        map[3] = "Three"
        map[4] = "Four"
    }

    val amp4 = mutableMapOf<Int, String>().also { map ->
        map[5] = "Five"
        map[6] = "Six"
        map[7] = "Seven"
        map[8] = "Eight"
    }

    println("Ключ есть: ${amp3[1]}\nКлюча нет: ${amp3.getOrDefault(42, "No key :(")}")

    amp3.remove(2)
    println(amp3.toString() + "\n")

    for ((i, j) in amp3) {
        println("$i == $j")
    }

    amp3[4] = "Four?"
    amp3[2] = "Not two"

    val amp5 = mutableMapOf<Int, String>().also {
        it.putAll(amp3)
        it.putAll(amp4)
    }

    println("\n" + amp5.toSortedMap() + "\n")

    val amp6 = mapOf<String, List<Int>>(
        "Year" to listOf(2, 0, 2, 4),
        "Time" to listOf(17, 31)
    )

    val amp7 = mapOf<Int, Set<String>>(
        2024 to setOf("Current", "Year"),
        1731 to setOf("Current", "Time")
    )

    val amp8 = mapOf<Pair<Int, Int>, Int>(
        20 to 23 to 4,
        17 to 31 to 3,
        65 to 12 to 6
    )

    println("\n${findKeyBySecondValueOfPair(amp8, 12)}\n")

    val library: MutableMap<String, MutableList<String>>

    val herbalist: Map<PlantsType, MutableList<String>>

    val quarterfinals: Map<String, MutableList<String>>

    val treatmentCourse: Map<LocalDate, List<String>>

    val travelersDict: Map<String, Map<String, String>>

}

fun findKeyBySecondValueOfPair(map: Map<Pair<Int, Int>, Int>, secondValue: Int): Pair<Int, Int> {

    for ((i, k) in map) {
        if (i.second == secondValue) return i
    }
    throw Exception("No such element")

}

enum class PlantsType {
    FLOWERS,
    TREES,
    GRASSES,
}