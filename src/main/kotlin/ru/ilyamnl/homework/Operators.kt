package ru.ilyamnl.homework

import kotlin.math.round


fun getCoeff(): Double? {
    val choice: List<Double?> = listOf(null, 0.2, 0.4, 0.8, null)
    return choice[(0..4).random()]
}

fun getIntensity(intensity: Double): Double {

    val initialIntensity: Double = intensity
    val attenuationCoefficient: Double? = getCoeff()
    return initialIntensity * (attenuationCoefficient ?: 0.5)

}

fun getInsuranceCost(cargoValue: Double? = null): Double {
    return round(0.005 * (cargoValue ?: 10000.0) * 100) / 100.0
}

fun alertAtmosphericPressure(temp: Float?, humidity: Float?, atmosphericPressure: Int?): Int {
    return atmosphericPressure ?: throw Exception("There is no atmospheric pressure!")
}

fun main() {

    println("${getIntensity(23.5)}\n" +
            "${getInsuranceCost()} $\n" +
            "${getInsuranceCost(235.8)} $\n" +
            "${alertAtmosphericPressure(23.5f, 0.81f, 762)} mmHg\n")
    println("${alertAtmosphericPressure(2358.12f, null, null)} mmHg")

}