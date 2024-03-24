package ru.ilyamnl.lessons

fun main() {


}

class ConditionalOperators {

    fun sample(arg: Int) {

        var arg2 = if (arg == 3) {
            arg * 4
        } else if (arg == 4) {
            arg * 3
        } else {
            3
        }

        var arg3 = when (arg) {
            3 -> arg * 4
            4 -> arg * 3
            else -> 3
        }

    }

    fun practiceFirst(hour: Int): String {

        return if (hour !in 0..23) "Wrong Hour"
        else if (hour in 8..11) "Morning"
        else if (hour in 12..17) "Day"
        else if (hour in 18..21) "Evening"
        else "Night"

    }

    fun practiceFirstOther(hour: Int): String {

        return when (hour) {
            !in 0..23 -> "Wrong Hour"
            in 8..11 -> "Morning"
            in 12..17 -> "Day"
            in 18..21 -> "Evening"
            else -> "Night"
        }

    }

    fun checkPassword(password: String): Boolean {

        // > 8 symbols
        // chars and digits

        if (password.length < 9) return false
        return checkNumbersAndSymbols(password)

    }

    // проверка на наличие как букв, так и чисел в пароле
    private fun checkNumbersAndSymbols(password: String): Boolean {
        val hasLetter = Regex(pattern = "[a-zA-Zа-яА-Я]").containsMatchIn(password)
        val hasNumber = Regex(pattern = "\\d").containsMatchIn(password)
        return hasLetter && hasNumber
    }

    // возвращает буквенную оценку в зависимости от балла
    fun getCharFromMark(mark: Int): Char {

        return when (mark) {
            100 -> 'A'
            in 80..99 -> 'B'
            in 60..79 -> 'C'
            in 40..59 -> 'D'
            in 20..39 -> 'E'
            in 0..19 -> 'F'
            else -> throw Exception("Wrong mark")
        }

    }

    // магазин делает скидки
    // >1000 = 10%
    // 500..1000 = 5%
    fun calculateDiscount(price: Double): Double {

        return if (price >= 1000.00) price * 0.9
        else if (price in 500.00..<1000.00) price * 0.95
        else price

    }

    fun calculateDiscountNotMine(price: Double): Double {

        return price * if (price > 0.0) {
            when (price) {
                in 0.00..<500.00 -> 1.0
                in 500.00..<1000.00 -> 0.95
                else -> 0.9
            }
        } else throw Exception("Price if lesser than zero")

    }

}