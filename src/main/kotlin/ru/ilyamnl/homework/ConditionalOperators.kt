package ru.ilyamnl.homework

fun main() {

    val a: ConditionalOperatorsHomework = ConditionalOperatorsHomework()

    val seasonWinter = a.seasonDefinition(12)
    val seasonSummer = a.seasonDefinition(6)
    val youngPuppet = a.getPetAge(1)
    val oldDoggy = a.getPetAge(15)
    val miniWalk = a.getOptimalTransport(0.8)
    val bicycleOnThePark = a.getOptimalTransport(4.6)
    val longRoadTrip = a.getOptimalTransport(545.7)
    val miniShopping = a.getNumberOfBonusPoints(399.99)
    val bigShopping = a.getNumberOfBonusPoints(147893.23)
    val getPng = a.getDocType("png")
    val getTempInC = a.tempConversion(50.0, 'F')
    val getTempInF = a.tempConversion(10.0, 'C')
    val whatIShouldWearOnASun = a.getClothesForAWeather(5506)
    val whatIShouldWearOnAPlusTenTemp = a.getClothesForAWeather(10)
    val whatCanIWatchWithMyFamily = a.getMovieCategory(9)

    println("""
        Month 12: $seasonWinter
        Month 6: $seasonSummer
        Young puppet: $youngPuppet
        Old doggy: $oldDoggy
        What should I use to get to the nearest store: $miniWalk
        What should I use to get around in a large park: $bicycleOnThePark
        What should I use to travel to Kazakhstan: $longRoadTrip
        Points for mini shopping: $miniShopping
        Points for big shopping: $bigShopping
        Oh, i see a png. And this means that it is: $getPng
        50 F in C: $getTempInC
        10 C in F: $getTempInF
        What I Should Wear On A Sun: $whatIShouldWearOnASun
        What I should wear, if out the door is +10 C: $whatIShouldWearOnAPlusTenTemp
        What can I watch with my family (I have 9 yo dog): $whatCanIWatchWithMyFamily 
    """.trimIndent())

}

class ConditionalOperatorsHomework {

    fun seasonDefinition(month: Int): String {

        return if (month in 1..12) {
            when (month) {
                in 3..5 -> "Spring"
                in 6..8 -> "Summer"
                in 9..11 -> "Autumn"
                else -> "Winter"
            }
        } else throw Exception("Wrong month")

    }

    fun getPetAge(years: Int): Double {

        return if (years > 2) 21 + (years - 2) * 4.0
        else if (years >= 0) years * 10.5
        else throw Exception("Wrong years")

    }

    fun getOptimalTransport(km: Double): String {

        if (km < 0) throw Exception("Wrong km")
        return when (km) {
            in 0.0..<1.0 -> "On foot"
            in 1.0..<5.0 -> "On bicycle"
            else -> "On road transport"
        }

    }

    fun getNumberOfBonusPoints(price: Double): Int {

        return if (price < 0.0) throw Exception("Wrong price")
        else if (price < 1000.0) price.toInt() / 100 * 2
        else price.toInt() / 100 * 5

    }

    fun getDocType(fileExtension: String): String {

        return when (fileExtension) {
            "txt" -> "Текстовый документ"
            "png" -> "Изображение"
            "xlsx" -> "Таблица"
            else -> "Неизвестный тип"
        }

    }
    
    fun tempConversion(temp: Double, unit: Char): String {

        return if ((unit == 'C' && temp < -273.15) || (unit == 'F' && temp < -459.67)) throw Exception("Extra low temperature")
        else if (unit == 'C') String.format("%.2f F", 32 + temp * 1.8)
        else if (unit == 'F') String.format("%.2f C", (temp - 32) / 1.8)
        else throw Exception("Wrong unit")

    }

    fun getClothesForAWeather(temp: Int): String {

        return when (temp) {
            in -30..0 -> "Куртка и шапка"
            in 0..14 -> "Ветровка"
            in 15..35 -> "Футболка и шорты"
            else -> "Не стоит выходить из дома"
        }

    }

    fun getMovieCategory(age: Int): String {

        if (age < 0) throw Exception("Age error")
        return when(age) {
            in 0..12 -> "Детские"
            in 13..17 -> "Подростковые"
            else -> "18+"
        }

    }

}