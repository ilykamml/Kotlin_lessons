package ru.ilyamnl.lessons

fun main() {

    // ЦИКЛ FOR
    // всё что создаётся внутри цикла - остаётся внутри цикла и действительно только в течении одной итерации
    val helloString: String = "Hello Kotlin"
    for (helloChars in helloString) {
        println(helloChars)
    }

    println()

    for (counter in 10 downTo 1) { // обратный диапазон
        println(counter * counter)
    }

    println()

    for (counter in 20 downTo 1 step 2) { // обратный диапазон с шагом убывания 2
        println(counter * counter * counter)
    }

    println()

    val range = 1..20 step 2 // можно делать вот так

    for (counter in range) {
        println(counter)
    }

    println()

    // ЦИКЛ WHILE

    while (true) { // бесконечный цикл в Kotlin
        break // не бесконечный цикл в Kotlin
    }

    var number = 2
    var degreesNumber = 0
    while (number > 0) {
        number *= number
        println(number)
        degreesNumber++
    }
    println(degreesNumber)

    println()

    // ЦИКЛ DO WHILE
    // сначала делает, потом думает
    // есть break и continue

    number = 0
    do {
        number++
        if (number > 2) break
    } while (true)
    println(number)

    println()

    //PRACTICE

    for (i in 1..10) {
        println(i * i)
    }

    println()

    for (i in 20 downTo 1) {
        if (i % 2 == 0) println(i)
    }

    println()

    for (i in 1..30 step 3) {
        println(i)
    }

    println()

    for (i in 100 downTo 50 step 5) println(i)

    println()

    for (i in 0..<30 step 3) println(i)

    println()

    var i = 1
    var sum = 0
    while (i < 11) {
        sum += i++
    }
    println(sum)

    println()



}