package ru.ilyamnl.lessons

import java.time.LocalTime

fun main() {

    // PAIR

    val pair: Pair<Int, String> = 1 to "string" // инициализация пары

    val pair1 = Pair(2, "string") // ещё инициализация пары

    println("${pair.first}\n${pair.second}\n")

    // используется для передачи данных в map

    // MAP
    // ключ всегда уникальны, значение - любое

    val map: Map<Int, String> = mapOf(pair, pair1) // неизменяемый словарь

    val map1 = mutableMapOf(
        1 to "Kotlin",
        2 to "Java",
        null to "null"
    )

    println(map1[1]) // достаём значение по ключу

    map1[3] = "Python" // создание новой пары в изменяемом словаре
    map1[2] = "Jaba"

    for ((key, value) in map1) {

        println("$key == $value")

    }

    map1.remove(null)
    map1.remove(3, "PytHONNN") // не удалится, тк нет такой пары, хоть и ключ есть
    println("\n\n")

    for ((key, value) in map1) {

        println("$key == $value")

    }

    // PRACTICE

    val map2: Map<String, Int> = mapOf()

    val map3: Map<Int, String> = mapOf(
        1 to "One",
        2 to "Two",
        3 to "Three"
    )

    val map4: MutableMap<String, String> = mutableMapOf(
        "" to "",
        "1" to "One",
        "2" to "Two"
    )

    map4["3"] = "Three"

    println(map4["3"])

    map4.remove("")

    map4["3"] = "Four?"

    map4.forEach {
        println("${it.key} == ${it.value}")
    }

    val map5: Map<String, List<Int>> = mapOf(
        "Codes" to listOf(3, 5, 8, 3),
        "Year" to listOf(1, 9, 9, 9),
        "Now" to listOf(2, 0, 2, 4)
    )

    val map6 = mapOf(
        listOf(3, 4, 7, 5) to "Codes",
        listOf(1, 9, 9, 9) to "Year",
        listOf(2, 0, 2, 4) to "Now",
        listOf(2, 0, 0, 0) to "Year"
    )

    val map7: Map<Int, String> = mapOf(
        3 to "Three?",
        4 to "Four",
        5 to "Five",
        6 to "Six"
    )

    val map8 = mapJoin(map3, map7)

    println(map8)

    println(findByKeyInMap(0, map6))

    println(findByValueInMap("Year", map6))

    // задачки на определение типов в создаваемом словаре(?)

    val employeeSchedule: Map<String, MutableList<String>> = mapOf(
        "Monday" to mutableListOf("Bob", "Mark"),
        "Tuesday" to mutableListOf("Bob", "Mark"),
        "Wednesday" to mutableListOf("Maxim", "Alex"),
        "Thursday" to mutableListOf("Maxim", "Alex"),
        "Friday" to mutableListOf("Maxim", "Alex"),
        "Saturday" to mutableListOf("Kirill", "Daniil"),
        "Sunday" to mutableListOf("Bob", "Mark")
    )

    val curriculum: MutableMap<String, MutableMap<String, String>> = mutableMapOf(
        "IT" to mutableMapOf(
            "Python for beginners" to "[description]",
            "Kotlin for advances" to "[description]"
        )
    )

    val gameInventory: Map<String, MutableSet<String>> = mapOf(
        "axe" to mutableSetOf("Dark axe", "Stone axe", "Copper axe"),
        "apple" to mutableSetOf("Golden apple", "apple")
    )

    val transportSchedule: Map<String, List<LocalTime>> = mapOf(
        "18У" to listOf(LocalTime.of(6, 30), LocalTime.of(7, 0))
    )

    val contacts: MutableMap<String, MutableMap<String, String>> = mutableMapOf(
        "Kolyan" to mutableMapOf(
            "phone" to "+79998884512",
            "email" to "kolyan1839@hmail.org"
        )
    )



}

fun mapJoin(map1: Map<Int, String>, map2: Map<Int, String>): Map<Int, String> {

    val resultMap = mutableMapOf<Int, String>()

    map1.forEach { resultMap[it.key] = it.value }
//    map2.forEach { if (it.key !in resultMap) resultMap[it.key] = it.value }
    map2.forEach { if (!resultMap.containsKey(it.key)) resultMap[it.key] = it.value }

    return resultMap.toMap()

}

fun findByKeyInMap(number: Int, map: Map<List<Int>, String>): String? {

    map.forEach { if (number in it.key) return it.value }
//    map.forEach { if (it.key.contains(number)) return it.value }
    return null

}

fun findByValueInMap(value: String, map: Map<List<Int>, String>): List<List<Int>>? {

    val resultList = mutableListOf<List<Int>>()
    map.forEach { if (value == it.value) resultList.add(it.key) }

    return if (resultList.size > 0) resultList else null

}