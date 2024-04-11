package ru.ilyamnl.homework

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class DateTimeConverter {

    private val zeroTime = LocalTime.MIDNIGHT

    fun convertToDateTime(input: String): LocalDateTime {

        return when(input.lowercase()) {
            "today" -> {
                LocalDateTime.now().with(zeroTime)
            }

            "tomorrow" -> {
                LocalDateTime.now().plusDays(1).with(zeroTime)
            }

            "yesterday" -> {
                LocalDateTime.now().minusDays(1).with(zeroTime)
            }

            else -> {
                parseDate(input)
            }
        }

    }

    private fun parseDate(input: String): LocalDateTime {
        val today = LocalDate.now()

        val timeParser = { formatter: DateTimeFormatter ->
            LocalDateTime.of(today, LocalTime.parse(input, formatter))
        }

        val dateParser = { formatter: DateTimeFormatter ->
            LocalDateTime.of(LocalDate.parse(input, formatter), zeroTime)
        }

        val dateTimeParser = { formatter: DateTimeFormatter ->
            LocalDateTime.parse(input, formatter)
        }

        val parsers = mapOf(
            "HH:mm" to timeParser,
            "HH:mm:ss" to timeParser,
            "yyyy.MM.dd" to dateParser,
            "yyyy.MM.dd, HH:mm" to dateTimeParser,
            "yyyy.MM.dd, HH:mm:ss" to dateTimeParser,
            "d MMM yyyy" to dateParser,
            "d MMM yyyy, HH:mm" to dateTimeParser,
            "d MMM yyyy, HH:mm:ss" to dateTimeParser
        )

        for ((format, parser) in parsers) {
            try {
                return parser(DateTimeFormatter.ofPattern(format))
            } catch (ignored: Throwable) {}
        }

        throw IllegalArgumentException("Unknown date format: $input")
    }

}