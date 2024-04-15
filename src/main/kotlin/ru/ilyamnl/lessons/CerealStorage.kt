package ru.ilyamnl.lessons

import ru.ilyamnl.homework.Cereal

interface CerealStorage {

    val containerCapacity: Float
    val storageCapacity: Float

    fun addCereal(cereal: Cereal, amount: Float): Float
    fun getCereal(cereal: Cereal, amount: Float): Float
    fun removeContainer(cereal: Cereal): Boolean
    fun getAmount(cereal: Cereal): Float
}

interface Kitchen {
    fun selectCookware(amount: Float): Cookware
    fun measureWater(cereal: Cereal, amount: Float): Float
    fun cook(cookware: Cookware): Dish
}

class Cookware(private val capacity: Float) {

    private val composition = mutableMapOf<Cereal, Float>()
    private var water = 0f

    fun getCapacity(): Float = capacity

    fun addCereal(cereal: Cereal, amount: Float) {
        composition[cereal] = composition.getOrDefault(cereal, 0f) + amount
    }

    fun addWater(amount: Float) {
        water += amount
    }

    fun getWaterAmount(): Float = water

    fun getCerealsComposition(): Map<Cereal, Float> = composition.toMap()
}


data class Dish(
    val porridgeComposition: String,
    val portions: Int
)

class CerealCookFacade(private val cerealStorage: CerealStorage, private val kitchen: Kitchen) {

    fun cook(cereal: Cereal, amount: Float): Dish {
        val waterAmount = kitchen.measureWater(cereal, amount)
        val cookware = kitchen.selectCookware(waterAmount + amount)
        cookware.addCereal(cereal, amount)
        cookware.addWater(waterAmount)
        return kitchen.cook(cookware)
    }

    fun cook(composition: Map<Cereal, Float>): Dish {
        val waterAmount = composition.map { kitchen.measureWater(it.key, it.value) }.sum()
        val cookware = kitchen.selectCookware(waterAmount + composition.values.sum())
        composition.forEach { cookware.addCereal(it.key, it.value) }
        cookware.addWater(waterAmount)
        return kitchen.cook(cookware)
    }

    fun buyCereal(cereal: Cereal, amount: Float) {
        TODO()
    }

}