package ru.ilyamnl.lessons

fun main() {
    DayOfWeek.MONDAY.printDayType()
    DayOfWeek.FRIDAY

    CoffeeType.LATTE
    create(CoffeeType.LATTE)
    println(CoffeeType.entries)
    println(CoffeeType.valueOf("ESPRESSO"))

    println(findBestCoffee(true, true))

    println(CoffeeType.determine("Espresso"))

    println(getCoffeeByRole(ItRoles.BACKEND_DEV))

    println(getCoffeeByRole(ItRoles.QA))


}

fun create(coffeeType: CoffeeType) {
    println(coffeeType.cost)
}

enum class DayOfWeek(val isWeekend: Boolean) { // важная и крутая штука которую нужно понять
    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true), // общепринятый стандарт
    ;

    fun printDayType() {
        if (isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }

}


enum class CoffeeType(
    val cost: Double,
    val coffeeBase: String,
    val recommendedSugar: Int,
    val hasMilk: Boolean = false
) {
    ESPRESSO(2.50, "Espresso", 0),
    LATTE(3.00, "Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.25, "Americano", 0),
    NESCAFE_CLASSIC(0.50, "Nescafe Classic", 0),
    ;

    fun description() =
        "The $coffeeBase ${if (hasMilk) "with" else "without"} milk costs \$$cost and is best with $recommendedSugar spoons of sugar."

    companion object {
        fun determine(coffeeBase: String): CoffeeType {

            return CoffeeType.entries.find { it.coffeeBase == coffeeBase }
                ?: throw  Exception("No $coffeeBase coffee :(")

        }

    }

}

enum class ItRoles() {
    CTO,
    TEAM_LEAD,
    UX_UI,
    GAME_DEV,
    CRM,
    PM,
    BACKEND_DEV,
    SYS_ADMIN,
    QA,
    ;
}

fun getCoffeeByRole(role: ItRoles): CoffeeType {

    return when(role) {
        ItRoles.CTO, ItRoles.TEAM_LEAD -> CoffeeType.ESPRESSO
        ItRoles.UX_UI, ItRoles.GAME_DEV -> CoffeeType.LATTE
        ItRoles.CRM, ItRoles.PM -> CoffeeType.CAPPUCCINO
        ItRoles.BACKEND_DEV, ItRoles.SYS_ADMIN -> CoffeeType.AMERICANO
        ItRoles.QA -> CoffeeType.NESCAFE_CLASSIC
    }

}

fun findBestCoffee(cheapest: Boolean, hasMilk: Boolean): CoffeeType {

    return if (cheapest) {
        CoffeeType.entries.sortedBy { it.cost }.first { it.hasMilk == hasMilk }
    } else {
        CoffeeType.entries.sortedByDescending { it.cost }.first { it.hasMilk == hasMilk }
    }

}

