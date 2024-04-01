package ru.ilyamnl.homework

fun main() {

    // ARRAYS

    val arr1: Array<Int> = arrayOf(1, 2, 3, 4, 5)

    val arr2: Array<String?> = arrayOfNulls<String>(10)

    val arr3 = DoubleArray(5) { index -> (index * 2).toDouble() }

    val arr4: IntArray = intArrayOf(3, 4, 6, 33, 8)

    for (i in arr4.indices) arr4[i] *= 3

    val arr5: Array<String?> = arrayOfNulls(3)

    arr5[1] = "Hello World"
    arr5[2] = "Bye-bye world"

    val arr6: IntArray = intArrayOf(1, 3, 6, 3, 7, 43, 4, 6, 4)
    val arr7 = IntArray(arr6.size)
    val arr7_1 = IntArray(arr6.size) { i -> arr6[i] }
    println(arr7_1.joinToString())
    var index = 0

    for (i in arr6) arr7[index++] = i

    val arr8 = intArrayOf(14, 21, 53)
    val arr9 = intArrayOf(7, 12, 24)
    val arr10 = IntArray(3)

    for (i in arr8.indices) arr10[i] = arr8[i] - arr9[i]

    val arr11 = arrayOf(3, 4, 3, 123, 67, 5, 1233)

    for (i in arrayOf(3, 5, 3, 6, 7, 9, 23, 4)) println(i)

    println("\n\n")

    // LISTS

    val list1: List<Int> = listOf()

    val list2 = listOf("Hello", "World", "Kotlin")

    val list3 = MutableList<Int>(5) { i -> i * i + i + 15 * (i + 10) }.also {

        it.addAll(listOf(658, 775, 282))
    }

    val list4: MutableList<String> = mutableListOf("Hello", "World")

    list4.add("Kotlin")

    for (i in list3) println(i)

    println(list4[1])

//    list3[2] = 10

    val list5 = listOf(493, 618, 125, 431, 482, 648, 234, 295, 568)

    println(simpleListSort(list5))

    val list6 = list3.toList()

    val list7 = list5 + list6

    val list8 = mutableListOf<Int>().apply {
        addAll(list5)
        addAll(list6)
    }

    val list9 = mutableListOf<Int>().apply {
        for (i in list5) this.add(i)
        for (i in list6) this.add(i)
    }

    println("$list7\n$list8\n$list9")

    list9.apply {

        var max: Int = this[0]
        var min: Int = this[0]

        for (i in this) {
            if (i > max) max = i
            if (i < min) min = i
        }

        println("\nmin = $min\nmax = $max")

    }

    println(list9.filter { it % 2 == 0 })
    println("\n\n")

    // SETS

    val set1: Set<Int> = setOf()

    val set2 = setOf(1, 2, 3)

    val set3 = mutableSetOf("Kotlin", "Java", "Scala").apply {
        add("Swift")
        add("Go")
    }

    val set4 = mutableSetOf(1, 3, 2, 5, 6).apply {
        remove(2)
    }

    for (i in set4) println(i)

    println(set3.any { it == "Java" })

    val set5 = setOf("Python", "Kotlin", "C++", "Django", "Java")

    val set6 = set3.toSet() + set5

    val set7 = set3.union(set5).toSet()

    val set8 = setUnion(set3, set5)

    println("$set6 \n$set7\n$set8")

    val set9 = set3.intersect(set5).toSet()

    val set10 = setIntersect(set3, set5)

    println("$set9\n$set10")

    val set11 = set3.subtract(set5)

    val set12 = set3 - set5

    val set13: Set<String> = setSubtract(set3.toSet(), set5)

    println("$set11\n$set12\n$set13")

}

fun setSubtract(set1: Set<String>, set2: Set<String>): Set<String> {

    val resultSet = mutableSetOf<String>()

    for (i in set1) if (i !in set2) resultSet.add(i)

    return resultSet.toSet()

}

fun setIntersect(set1: Set<String>, set2: Set<String>): Set<String> {

    val resultSet = mutableSetOf<String>()

    if (set1.size < set2.size) {
        for (i in set1) if (i in set2) resultSet.add(i)
    } else {
        for (i in set2) if (i in set1) resultSet.add(i)
    }

    return resultSet.toSet()

}

fun findIndex(arr: Array<Int>, value: Int): Int {

    for (i in arr.indices) if (arr[i] == value) return i
    return -1

}

fun findIndexStr(arr: Array<String>, value: String): Int {

    for (i in arr.indices) if (arr[i] == value) return i
    return -1

}

fun simpleListSort(list: List<Int>): List<Int> {

    val tempList = list.toMutableList()

    for (i in tempList.indices) {
        for (j in i+1..<tempList.size) {

            if (tempList[j] < tempList[i]) {
                val tmp = tempList[j]
                tempList[j] = tempList[i]
                tempList[i] = tmp
            }

        }
    }

    return tempList.toList()

}

fun setUnion(set1: Set<String>, set2: Set<String>): Set<String> {

    val resultSet: MutableSet<String> = mutableSetOf()

    for (i in set1) resultSet.add(i)
    for (i in set2) resultSet.add(i)

    return resultSet.toSet()

}