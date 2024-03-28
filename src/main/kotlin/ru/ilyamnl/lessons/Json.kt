package ru.ilyamnl.lessons

import com.google.gson.*
import java.lang.reflect.Type
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


fun main() {

    // ПРОСТЕЙШИЙ СПОСОБ ИСПОЛЬЗОВАНИЯ
    val gson = Gson() // вещь для работы с JSON
    val mdc1 = MyDataClass("First", 1)
    val result = gson.toJson(mdc1) // сериализация
    println(result)
    val mdc2 = gson.fromJson(result, MyDataClass::class.java) // де сериализация
    println(mdc2)

    // ИСПОЛЬЗОВАНИЕ С ПРИКОЛАМИ (красивый json, например)
    val gson2 = GsonBuilder()
        .setPrettyPrinting()
        .create()
    println(gson2.toJson(mdc1))
    println("\n\n\n")

    // ДАТА
    // сохранять как форматированную дату или как тайм стемп
    // или использовать интерфейсы

    // ПРАКТИКА
    val student1 = Student(
        "Victor", "Kot",
        OffsetDateTime.now(ZoneOffset.of("+03:00")).minusYears(19).minusDays(23), null,
        CoffeeType.CAPPUCCINO
    )

    val student2 = Student(
        "Arseniy", "Web",
        OffsetDateTime.now(ZoneOffset.of("+03:00")).minusYears(18).minusDays(149),
        "Computer Science", CoffeeType.LATTE
    )

    val fac1 = Faculty("Engineering", 1965, listOf(student2, student1))

    val university = University("BelSut", listOf(fac1))

    println(university.toString() + "\n\n")

    val gson3 = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeSerializer())
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeDeserializer())
        .setPrettyPrinting()
        .create()

    val resultUniversity = gson3.toJson(university)
    println(resultUniversity)

    val university2 = gson3.fromJson(resultUniversity, University::class.java)
    println(university2)


}

data class MyDataClass(
    val property1: String,
    val property2: Int
)

data class Student(
    val firstName: String,
    val lastName: String,
    val enrollmentDate: OffsetDateTime,
    val major: String?,
    val coffeeType: CoffeeType
)

data class Faculty(
    val name: String,
    val establishedYear: Int,
    val studentsList: List<Student>
)

data class University(
    val name: String,
    val facultiesList: List<Faculty>
)

class OffsetDateTimeSerializer : JsonSerializer<OffsetDateTime> {
    override fun serialize(src: OffsetDateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(src?.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
    }
}

class OffsetDateTimeDeserializer : JsonDeserializer<OffsetDateTime> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): OffsetDateTime {
        return OffsetDateTime.parse(json?.asJsonPrimitive?.asString, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }
}
