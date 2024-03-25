package ru.ilyamnl.homework

import kotlin.math.abs
import kotlin.math.log10

fun main() {

    // FOR
    // ПРЯМОЙ ДИАПАЗОН
    for (i in 1..5) println(i)

    println()

    for (i in 2..10 step 2) println(i)

    println()

    // ОБРАТНЫЙ ДИАПАЗОН

    for (i in 5 downTo 1) println(i)

    println()

    for (i in 10 downTo 1 step 2) println(i)

    println()

    // С ШАГОМ

    for (i in 1..9 step 2) println(i)

    println()

    for (i in 1..20 step 3) println(i)

    println()

    // ИСПОЛЬЗОВАНИЕ ДО

    for (i in 1..<9) println(i)

    println()

    for (i in 3..<15) println(i)

    println()

    // WHILE
    // ЦИКЛ

    var i = 1
    while (i < 6) {
        println(i++)
    }
    i = 10

    println()

    while (i > 4) {
        println(i--)
    }

    println()

    // ПРЕРЫВАНИЕ И ПРОПУСК

    for (i in 1..10) {
        if (i == 6) break
    }

    i = 0
    while (true) {
        println(++i)
        if (i == 10) break
    }

    println()

    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }

    println()

    i = 1
    while (i < 11) {
        if (i % 3 != 0) println(i)
        i++
    }

    println()

    // ЗАДАЧА НА ВЛОЖЕННЫЙ ЦИКЛ

    println(getMultiplicationTable(30, 30))


}

fun getMultiplicationTable(height: Int, weight: Int): String {
    if (height < 1 || weight < 1) throw Exception("Bad size")
    var result: String = ""
    val spaces = (height * weight).length() + 1
    var tempResult: Int = 0
    for (i in 1..height) {
        for (j in 1..weight) {
            tempResult = i * j
            result += "${" ".repeat(spaces - tempResult.length())}$tempResult"
        }
        result += "\n"
    }
    return result
}

fun Int.length() = when(this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}
