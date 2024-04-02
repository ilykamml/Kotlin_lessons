package ru.ilyamnl.homework

import com.google.gson.*
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {

    val gson = GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeSerializer())
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeDeserializer())
        .create()

    val runs = listOf(
        TestRun(
            "0.1",
            RunResult.SUCCESS,
            LocalDateTime.now().minusYears(1).withHour(17),
            null
        ),
        TestRun(
            "0.2",
            RunResult.SKIPPED,
            LocalDateTime.now().minusMonths(7).withHour(12),
            null
        ),
        TestRun(
            "0.3",
            RunResult.FAILURE,
            LocalDateTime.now().minusMonths(5).withHour(13),
            "App not loaded home screen"
        ),
        TestRun(
            "0.4",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(5).plusDays(2).withHour(14),
            null
        ),
        TestRun(
            "0.5",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(4).withHour(19),
            null
        ),
        TestRun(
            "0.6",
            RunResult.SKIPPED,
            LocalDateTime.now().minusMonths(3),
            null
        ),
        TestRun(
            "0.7",
            RunResult.FAILURE,
            LocalDateTime.now().minusMonths(3).plusDays(3),
            "App not loaded photo"
        ),
        TestRun(
            "0.8",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(3).plusDays(5),
            null
        ),
        TestRun(
            "0.9",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(1),
            null
        )
    )

    val steps = listOf(
        TestStep(
            1,
            "Open app",
            "App has opened"
        ),
        TestStep(
            2,
            "Enter name",
            "Name in field"
        ),
        TestStep(
            3,
            "Enter password",
            "Password entered"
        ),
        TestStep(
            4,
            "Click login button",
            "App loaded home screen"
        ),
        TestStep(
            5,
            "Click settings button",
            "App opened settings tab"
        ),
        TestStep(
            6,
            "Click on avatar",
            "App opened avatar change tab"
        ),
        TestStep(
            7,
            "Click on change photo button",
            "App opened phone gallery"
        ),
        TestStep(8,
            "Click on second photo",
            "App loaded selected photo"),
        TestStep(
            9,
            "Click apply button",
            "App display notification about avatar change"
        ),
        TestStep(
            10,
            "Click back button",
            "App open settings tab, new photo must be displayed"
        )
    )

    val firstCase = TestCase("a_c",
        "Avatar change test",
        LocalDateTime.now().minusYears(1).minusDays(39).withHour(12).withMinute(0),
        Critically.LOW,
        "Ilya",
        Risk.LOW,
        runs,
        steps
        )

    println(firstCase)

    val runs2 = listOf(
        TestRun(
            "0.1",
            RunResult.SUCCESS,
            LocalDateTime.now().minusYears(1).withHour(17),
            null
        ),
        TestRun(
            "0.2",
            RunResult.FAILURE,
            LocalDateTime.now().minusMonths(7).withHour(12),
            "Message not sent"
        ),
        TestRun(
            "0.3",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(5).withHour(13),
            null
        ),
        TestRun(
            "0.4",
            RunResult.SKIPPED,
            LocalDateTime.now().minusMonths(5).plusDays(2).withHour(14),
            null
        ),
        TestRun(
            "0.5",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(4).withHour(19),
            null
        ),
        TestRun(
            "0.6",
            RunResult.FAILURE,
            LocalDateTime.now().minusMonths(3),
            "Message not sent"
        ),
        TestRun(
            "0.7",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(3).plusDays(3),
            null
        ),
        TestRun(
            "0.8",
            RunResult.SKIPPED,
            LocalDateTime.now().minusMonths(3).plusDays(5),
            null
        ),
        TestRun(
            "0.9",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(1),
            null
        )
    )

    val steps2 = listOf(
        TestStep(
            1,
            "Open app",
            "App has opened"
        ),
        TestStep(
            2,
            "Enter name",
            "Name in field"
        ),
        TestStep(
            3,
            "Enter password",
            "Password entered"
        ),
        TestStep(
            4,
            "Click login button",
            "App loaded home screen"
        ),
        TestStep(
            5,
            "Click messages button",
            "App opened messages tab"
        ),
        TestStep(
            6,
            "Click on Favorites",
            "App opened Favorites tab"
        ),
        TestStep(
            7,
            "Click on a contact",
            "App opened chat with the contact"
        ),
        TestStep(
            8,
            "Type a message",
            "Message typed in the input field"
        ),
        TestStep(
            9,
            "Click send button",
            "Message sent"
        ),
        TestStep(
            10,
            "Check if message appears in the chat",
            "Message appears in the chat"
        )
    )

    val secondCase = TestCase(
        "b_c",
        "Send message to Favorites",
        LocalDateTime.now().minusYears(1).minusDays(39).withHour(12).withMinute(0),
        Critically.HIGH,
        "Ilya",
        Risk.LOW,
        runs2,
        steps2
    )

    println(secondCase)

    val runs3 = listOf(
        TestRun(
            "0.1",
            RunResult.SUCCESS,
            LocalDateTime.now().minusYears(1).withHour(17),
            null
        ),
        TestRun(
            "0.2",
            RunResult.FAILURE,
            LocalDateTime.now().minusMonths(7).withHour(12),
            "Account not created"
        ),
        TestRun(
            "0.3",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(5).withHour(13),
            null
        ),
        TestRun(
            "0.4",
            RunResult.FAILURE,
            LocalDateTime.now().minusMonths(5).plusDays(2).withHour(14),
            "Video not posted"
        ),
        TestRun(
            "0.5",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(4).withHour(19),
            null
        ),
        TestRun(
            "0.6",
            RunResult.FAILURE,
            LocalDateTime.now().minusMonths(3),
            "Account not created"
        ),
        TestRun(
            "0.7",
            RunResult.FAILURE,
            LocalDateTime.now().minusMonths(3).plusDays(3),
            "Video not posted"
        ),
        TestRun(
            "0.8",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(3).plusDays(5),
            null
        ),
        TestRun(
            "0.9",
            RunResult.SUCCESS,
            LocalDateTime.now().minusMonths(1),
            null
        )
    )

    val steps3 = listOf(
        TestStep(
            1,
            "Open app",
            "App has opened"
        ),
        TestStep(
            2,
            "Click on create account button",
            "App opened account creation form"
        ),
        TestStep(
            3,
            "Enter username",
            "Username entered"
        ),
        TestStep(
            4,
            "Enter password",
            "Password entered"
        ),
        TestStep(
            5,
            "Click on create account button",
            "Account created"
        ),
        TestStep(
            6,
            "Click on post video button",
            "App opened video upload form"
        ),
        TestStep(
            7,
            "Select video with kittens",
            "Video selected"
        ),
        TestStep(
            8,
            "Click on post button",
            "Video posted"
        ),
        TestStep(
            9,
            "Check if video appears on the feed",
            "Video appears on the feed"
        )
    )

    val thirdCase = TestCase(
        "c_c",
        "Create new account and post video with kittens",
        LocalDateTime.now().minusYears(1).minusDays(39).withHour(12).withMinute(0),
        Critically.LOW,
        "Ilya",
        Risk.LOW,
        runs3,
        steps3
    )

    val fourCase = TestCase(
        "empty_case",
        "is app exists?",
        LocalDateTime.now().minusDays(24),
        Critically.LOW,
        "Ilya",
        Risk.HIGH,
        emptyList(),
        emptyList()
    )

    println(thirdCase)


    println(gson.toJson(firstCase))

    val testCases = listOf(firstCase, secondCase, thirdCase)

    println(getFailureTestsById(testCases, "0.7"))

    println("%.2f".format(getSkippedTestPercentage(testCases, "0.4")) + " %")

    testCases.forEach { testCase -> println("${testCase.name} == ${fixRiskField(testCase).risk}") }
    println("${fourCase.name} == ${fixRiskField(fourCase).risk}")




}

data class TestCase(
    val id: String,
    val name: String,
    val creationDateTime: LocalDateTime,
    val criticality: Critically,
    val author: String,
    val risk: Risk,
    val runs: List<TestRun>,
    val steps: List<TestStep>
)

data class TestStep(
    val stepNumber: Int,
    val action: String,
    val expectedResult: String
)

data class TestRun(
    val runId: String,
    val result: RunResult,
    val runDateTime: LocalDateTime,
    val defectLink: String?
)

enum class Critically {
    LOW, MIDDLE, HIGH
}

enum class Risk {
    LOW, MIDDLE, HIGH
}

enum class RunResult {
    SUCCESS, FAILURE, SKIPPED
}

class LocalDateTimeSerializer : JsonSerializer<LocalDateTime> {
    override fun serialize(src: LocalDateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(src?.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
    }
}

class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): LocalDateTime {
        return LocalDateTime.parse(json?.asJsonPrimitive?.asString, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }
}

fun getFailureTestsById(testCases: List<TestCase>, id: String): List<TestRun> {

    val failureRuns = mutableListOf<TestRun>()

    testCases.forEach {
        it.runs.forEach { run ->
            if (run.runId == id && run.result == RunResult.FAILURE) failureRuns.add(run)
        }
    }

    return failureRuns

}

fun getSkippedTestPercentage(testCases: List<TestCase>, id: String): Double {

    val skipCount = testCases.count { testCase ->
        testCase.runs.find { it.runId == id }?.result == RunResult.SKIPPED
    }.toDouble()

    return (skipCount / testCases.size.toDouble() ) * 100.0

}

fun fixRiskField(testCase: TestCase): TestCase {

    return if (isItHighRisk(testCase)) {
        testCase.copy(risk = Risk.HIGH)
    } else if (isItMiddleRisk(testCase)) {
        testCase.copy(risk = Risk.MIDDLE)
    } else if (isItLowRisk(testCase)) {
        testCase.copy(risk = Risk.LOW)
    } else {
        testCase
    }

}

fun isItHighRisk(testCase: TestCase): Boolean {

    val lastFailure = getLastFailure(testCase)
    val lastDefect = getLastDefect(testCase)
    val isNew = testCase.creationDateTime.isAfter(LocalDateTime.now().minusMonths(2))
    val hasFailuresInLastMonth = lastFailure?.isAfter(LocalDateTime.now().minusMonths(1)) ?: false
    val hasDefectsInLastSixMonth = lastDefect?.isAfter(LocalDateTime.now().minusMonths(6)) ?: false

    return (isNew) || (testCase.criticality == Critically.MIDDLE && hasFailuresInLastMonth)
            || (testCase.criticality == Critically.HIGH && hasDefectsInLastSixMonth)

}

fun isItMiddleRisk(testCase: TestCase): Boolean {

    val lastDefect = getLastDefect(testCase)
    val hasDefectInLastSixMonth = lastDefect?.isAfter(LocalDateTime.now().minusMonths(6)) ?: false
    val hasDefectBetweenTwoAndFourMonth = lastDefect?.isAfter(LocalDateTime.now().minusMonths(4)) ?: false
            && lastDefect?.isBefore(LocalDateTime.now().minusMonths(2)) ?: false
    val hasDefectInLastTwoMonth = lastDefect?.isAfter(LocalDateTime.now().minusMonths(2)) ?: false

    return (testCase.criticality == Critically.HIGH && !hasDefectInLastSixMonth)
            || (testCase.criticality == Critically.MIDDLE && hasDefectBetweenTwoAndFourMonth)
            || (testCase.criticality == Critically.LOW && hasDefectInLastTwoMonth)

}

fun isItLowRisk(testCase: TestCase): Boolean {

    return testCase.criticality == Critically.HIGH || testCase.criticality == Critically.LOW

}

fun getLastFailure(testCase: TestCase): LocalDateTime? {

    testCase.runs.reversed().forEach { run ->
        if (run.result == RunResult.FAILURE) return run.runDateTime
    }
    return null

}

fun getLastDefect(testCase: TestCase): LocalDateTime? {

    testCase.runs.reversed().forEach { run ->
        if (run.defectLink == null) return run.runDateTime
    }
    return null

}
