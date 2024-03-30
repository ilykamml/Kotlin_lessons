 package ru.ilyamnl.lessons

fun main() {

    // int[] arr - jaba

    val arr: Array<String> = arrayOf("1", "2", "3") // массив в котлине
    arr[0] = "3"
    println(arr[0])
    println(arr)

    // IntArray, LongArray - оптимизированный для производительности

    val list: List<Int> = listOf(1, 2, 3) // специальный тип, который предоставляет возможность хранения данных | Список
                                        // в виде списка; Он индексированный; В список можно добавлять значения?
    val list2: MutableList<Int> = mutableListOf(1, 2, 3) // вот сюда уже можно добавлять и удалять элементы
    list2.add(4)
    list2.addAll(listOf(5, 6))
    list2.removeAt(0)
    println(list2)

    val set: Set<Long> = setOf(32L, 45L, 7634L, 2351L, 5324L, 5311L, 32L) // Множество, не упорядочено, только уникальные значения
    println(set)
    val set2: MutableSet<Long> = mutableSetOf(3L, 2L, 2L, 5L, 6L, 324L) // Изменяемое множество
    set2.add(2L)
    set2.remove(2L)
    println(set2)

    println(set.filterNot { it % 2L == 0L || it % 5L == 0L }) // filter через лямбда выражение

    // PRACTICE

    val arr2: Array<Int> = arrayOf(5, 2, 8)

    val emptyArray: Array<Int> = emptyArray()

    val emptyNullArray: Array<Int?> = arrayOfNulls<Int>(5) // массив null'ов

    val arrForCycle: Array<Int?> = arrayOfNulls<Int>(10)

    for (i in arrForCycle.indices) {
        arrForCycle[i] = i * i / 2
    }

    println(arrForCycle.joinToString(" | ", prefix = "[ ", postfix = " ]")) // полезно

    val arr3: Array<Int?> = arrayOf(1, 2, 3)

    for (i in arr3.indices) arr3[i] = null

    println(arr3.joinToString(" | ", prefix = "[ ", postfix = " ]"))

    val arr4: Array<Int> = arrayOf(1, 2, 3, 5)
    val arr5: Array<Int> = arrayOf(3, 2, 1)
    val arr6: Array<Int> = arrayOf(5, 7, 23, 5)

    println(arrayCopy(arr4, arr5).toList())

    println((arr4 + arr5).toList())


    println(findIndex(arr6, 23))
    println(findIndex(arr6, 100))

    println(arraySummator(arr4, arr6).toList())
    println(arrayReverse(arraySummator(arr4, arr6)).toList())

    val list3: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8)

    val list4: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8)
    list4.add(5)
    list4.removeAt(3)
    list4.remove(7)
    list4[2] = 10

    for (i in list4) println(i)

    println("\n\n")

    for (i in list4.indices) println("$i = ${list4[i]}")

    val arr7: Array<String> = arrayOf("abc", "kotlin", "jaba")

    println(searchStringInArray(arr7, "jaba"))

    println(arr7.any { it == "kotlin" }) // ЗАПОМНИТЬ


}

fun arrayCopy(arr1: Array<Int>, arr2: Array<Int>): Array<Int> {

    if (arr1.size >= arr2.size) {
        for (i in arr2.indices) arr1[i] = arr2[i]
        return arr1
    } else {
        for (i in arr1.indices) arr2[i] = arr1[i]
        return arr2
    }

}

fun arraySummator(arr1: Array<Int>, arr2: Array<Int>): Array<Int> {

    if (arr1.size == arr2.size) {
        val result = Array(arr1.size) { 0 } // создаём массив размера size и заполнится нулями через лямбда функцию
        for (i in result.indices) result[i] += arr2[i] + arr1[i]
        return result
    } else throw IllegalArgumentException("arr1 != arr2")

}

fun findIndex(arr: Array<Int>, value: Int): Int {

    for (i in arr.indices) if (arr[i] == value) return i
    return -1

}

fun arrayReverse(arr: Array<Int>): Array<Int> {

    val reversedArray = Array(arr.size) { 0 }

    for (i in arr.size - 1 downTo 0) reversedArray[arr.size - i - 1] = arr[i]

    return reversedArray

}

fun searchStringInArray(arr: Array<String>, str: String): Boolean {

    for (i in arr) if (str == i) return true
    return false

}