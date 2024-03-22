package ru.ilyamnl.lessons

import java.util.Date

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    println("Hello world!")

}

val value: String = "Hellou" // не изменяемое (лучше использовать его)

var variable: Int = 123 // изменяемое (лучше его не использовать)

fun changeVar(other: Int) {
    var counter = 0
    counter++
    variable = counter
}

const val VERSION = "2.0" // константа
const val COUNT_OF_WHEELS: Int = 4

class Sample {

    private var privateField: String = ""

    val lazyValue: String by lazy { // рассчёт будет произведён только тогда, когда эту переменную вызовут в коде (инициализация по запросу)
        "Hello"
    }

    lateinit var userName: String // отложенная инициализация, перед использованием туда надо что-нибудь записать

    init { // инициализация userName, тогда lateinit не нужен и в переменную можно просто присвоить пустую строку
        userName = "ilya"
    }

    fun setValue(v: String) { // инициализация userName, тогда lateinit нужен, потому что нет init
        userName = v
    }

    fun getPrivateField(): String { // getter для приватного поля
        return privateField
    }

    fun setPrivateField(value: String) { // setter для приватного поля
        if (value.isEmpty()) return // если value пустой - не записываем
        privateField = value
    }

    var publicField: String = "" // примеры getter и setter для публичной переменной
        get() {
            return field
        }
        set(value: String) {
            if (value.isEmpty()) return
            field = value
        }

}

class Car {

    val vinNumber: String = "000005" // ВИН (уникальный) номер машины
    var carColor: String = "Black"
    var carMileage: Float = 0f
    lateinit var carOwner: String
    lateinit var carInsurance: String
    val utilizationReport: String by lazy {
        ""
    }
    var fuel: Float = 0f
        set(value: Float) {
            if (value < 0) return
            field += value
        }
    var uniqueEngineNumber: String = "000002"
    var currentSpeed: Float = 0f
        set(value: Float) {
            field = if (value > 180f) {
                180f
            } else {
                value
            }
        }
    val fuelType: String = "petrol"
    var numberOfPreviousOwners: Int = 0
        private set // запрещают установку нового значения вне класса, то есть менять значение можно только внутри класса
    val registrationDocument: String by lazy {
        ""
    }
    val carConfigurationDocument: String by lazy {
        "specs"
    }
    val tiresPressure: List<Float> = listOf(2.8f, 2.8f, 2.8f, 2.8f) // создание списков
    var conditionerStatus: Boolean = false
    var batteryChargeStatus: Float = 0.5f
        set(value) {
            if ((value < 0f) and (value > 1f)) return
            field = value
        }
    lateinit var dateOfMaintenance: Date
    lateinit var navigationSystem: String

}

