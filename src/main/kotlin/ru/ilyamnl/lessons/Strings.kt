package ru.ilyamnl.lessons

import kotlin.math.min

fun main() {

    // у строк есть встроенные методы
    val simpleString = "Hello World" // строка - неизменяемая

    val firstName = "Ivan"
    val lastName = "Ivanov"

    val fullName = firstName + " " + lastName // это старое и из джавы

    val age = 30

    // ШАБЛОНЫ

    val greeting = "Hello! My name is $fullName and I am $age years old"

    println(greeting)

    val person = Person("Alex", 25)
    val introduction = "My name is ${person.name} and I am ${person.age} years old"

    println(introduction)

    val details = "There is ${getDetails()}"

    println(details)

    val x = 10
    val y = 20

    val resultString = "x + y = ${x + y}"

    println(resultString)

    // МАНИпуляции со строками

    val originalString = "Kotlin is-fun"
    val subString = originalString.substring(7) // начинает с 7 символа
    val subString2 = originalString.substring(3, 6) // 6 не включает

    println("$subString2 $subString")

    val replacedString = originalString.replace("fun", "awesome")

    println(replacedString)

    val words = originalString.split(" ", "-") // пробел и тире считаются разделителями

    println(words)

    val length = "Hello World".length

    println(length)

    val upper = "Hello World".uppercase() // "HELLO WORLD"
    val lower = "Hello World".lowercase() // "hello world"
    val trimmed = "  Hello   world   ".trim() // убирает лишние пробелы по краям текста
    println(trimmed)

    val starts = "Kotlin".startsWith("Kot")
    val ends = "Kotlin".endsWith("lin")

    val contains = "Hello".contains("ell")

    val empty = "".isNullOrEmpty()

    val blank = "   ".isNullOrBlank() // пробелы не считает за символы

    val repeat = "ab".repeat(3)

    val letter = originalString[5] //"n"

    val multilineString = """
        First string
        Second string
        Third string
    """.trimIndent()

    val name = "Alex"
    val city = "Moscow"
    val friendsCount = 1052
    val rating = 4.948
    val balance = 2534.75856
    val text = """
        Name: %s
        City: %s
        Age: %d
        Friends count: %,d
        User rating: %.1f ⭐
        Balance: $ %,.2f
    """.trimIndent() // "," разбивает число на группы по три символа

    println("\n" + text.format(name, city, age, friendsCount, rating, balance) + "\n")

    // PRACTICE

    println("""
        ${ironicStringConversion("Ошибка! исправить это очень важно")}
        ${ironicStringConversion("Это нужно срочно решить!")}
    """.trimIndent())

    val phrase = "Kotlin: The Fun Way To Learn Programming"
    println(phrase.substring(8, 19))

    val mail1 = "example@gmail.com"

    println(mail1.substring(mail1.indexOf("@")+1))

    val phoneNumber = "123-456-7890"

    println(phoneHider(phoneNumber))

    println(dateFormat("20201005"))

    val test = "this [is [braces [inside] the] braces] [but] its not so [easy] as it [looks]"

    println(getTextFromBraces(test))


}

class Person(val name: String, val age: Int)

fun getDetails(): String {
    return "very interesting details"
}

fun ironicStringConversion(input: String): String {

    return when {
        input.startsWith("ошибка", true) -> {
            input.replace("ошибка", "Небольшое недоразумение", true)
        }
        input.endsWith("важно", true) -> {
            "$input.. Но не критично"
        }
        input.contains("проблема", true) -> {
            input.replace("проблема", "неожиданность", true)
        }
        input.indexOf("срочно", ignoreCase = true) in 0..10 -> {
            input.replaceFirst("срочно", "когда-нибудь", true)
        }
        input.isBlank() -> {
            "Кажется кто-то забыл что-то сказать"
        }
        else -> input
    }

}

fun phoneHider(phoneNumber: String): String {

    // ***-***-7890
    val toHide = phoneNumber.substring(phoneNumber.lastIndexOf("-")+1)

    return "xxx-xxx-$toHide"

}

fun dateFormat(date: String): String {

    val dateBites = listOf(date.substring(0, 4), date.substring(4, 6), date.substring(6, 8))

    return dateBites.joinToString(".")

}

fun getTextFromBraces(input: String): List<String> {

    if (input.isBlank()) {
        return emptyList()
    }

    val braces = input.mapIndexed { index, c -> if (c == '[' || c == ']') (c to index) else null }.filterNotNull()

    if (braces.isEmpty()) {
        return emptyList()
    }

    val bracesMap = mutableMapOf<Int, Int>()

    var i = 0
    for ((brace, index) in braces) {
        i++
        if (brace == '[') {
            var needClosedBraces = 1
            findClosedBrace@ for ((braceB, indexB) in braces.slice(i..<braces.size)) {
                if (braceB == '[') {
                    needClosedBraces++
                    continue
                } else {
                    needClosedBraces--
                    if (needClosedBraces == 0) {
                        bracesMap[index] = indexB
                        break@findClosedBrace
                    }
                }

            }
        }
    }

    val resultList = bracesMap.map { input.substring(it.key, it.value+1) }

    return resultList // done lesson

}

