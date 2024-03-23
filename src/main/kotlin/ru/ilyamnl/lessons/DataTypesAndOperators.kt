package ru.ilyamnl.lessons

fun main(): Unit {

    // Целочисленные типы
    var integer: Int = 388834453 // дефолт
    var long: Long = 888888888888 // если надо много цифр
    var short: Short = 12304 // меньше дефолта
    var byte: Byte = 54 // вообще жестб как меньше дефолта

    // Типы с плавающей точкой
    var float: Float = 123.456F // дефолтный тип, не очень много значений после запятой
    var double: Double = 3.4356234634522345 // Больше значений после запятой -> выше точность. Используем обычно его

    // Логический тип
    var boolean: Boolean = true

    // Символьный тип
    var char: Char = 'a' // только один символ, и только в одинарных кавычках

    // Строчный тип
    var string: String = "Kot"
    string += "lin"
    var string2: String = "Kotli"
    string2 += "n"
    if (string == string2) println("Equal")

    // Массивы
    var array: Array<Int> = arrayOf(1, 2, 3) // массив - список с установленным и неизменяемым кол-вом элементов

    // про var и val
    integer = 2 // переменная - подчёркнутая, потому что она var
    val value: Int = 0 // переменная - не подчёркнутая, потому что она val и не изменяется
    // integer = null - в котлине так сделать нельзя, потому что integer не может принимать null,
    // но мы можем сделать вот так:
    val integer2: Int? = null // при добавлении "?" к типу переменной - она становится nullable

    // Тип что угодно
    val any: Any = "" // использовать только тогда, когда знаешь что делаешь

    // Тип unit
    val any2: Unit // этому типу ничего нельзя присвоить, обычно присваивается методу, который ничего не возвращает

    fun unit() = Unit // метод который ничего не производит и ничего не возвращает

    //
    // а теперь основные операторы
    //

    // арифметика
    val sum = 10 + 5
    val diff = 10 - 5
    val product = 10 * 5
    val quotient = 10 / 5 // 10 / 4 == 2, тк это всё Int
    val reminder = 10 % 5 // остаток от деления

    // сравнение
    val isEqual = ( 5 == 5 )
    val isNotEqual = ( 5 != 6 )
    val isGreater = ( 5 > 3 )
    val isLesser = ( 3 < 5 )
    val isGreaterOrEqual = ( 5 >= 5 )
    val isLesserOrEqual = ( 5 <= 7 )

    // логические операторы
    val andResult = ( 5 > 4 ) && ( 5 > 5 ) // false
    val orResult = ( 5 > 3 ) || ( 5 < 4 ) // true
    val notResult = !( 5 > 3 ) // false

    // операторы присваивания
    // = - оператор присваивания
    var number = 3
    number += 2 // 5
    number -= 4 // 1
    number *= 10 // 10
    number /= 5 // 2

    // инкремент и декремент
    var counter = 0
    while (++counter < 100) { // Если инкремент слева - выполнится сначала он. Если инкремент справа - сначала выполнится сравнение
        counter++ // постфиксный инкремент
        ++counter // префиксный инкремент
    }

    // оператор Элвиса
    val valueS: String? = null
    val result = valueS ?: "Unknown" // "?:" - оператор Элвиса. Проверка на null. Если Null - то будет Unknown

    // Приоритеты операций
    val resultPriority = 10 - 5 * 3 // -5
    val boolPriority = false || true && !false // true

}

fun practice(): Unit {

    val defaultVolumeLevel: Short = 30
    var userVolumeLevel: Short? = null

    var currentVolumeLevel: Short = userVolumeLevel ?: defaultVolumeLevel

    var container: String? = "Baguette"
    var product: String = container ?: throw Exception("No container") // вызов ошибки при отсутствии контейнера

}