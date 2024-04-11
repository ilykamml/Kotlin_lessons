package ru.ilyamnl.homework

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime
import java.time.LocalTime

class DateTimeConverterTest {

    private val converter = DateTimeConverter()

    companion object {

//        "Сегодня" -> сегодняшняя дата, время 00:00
//        "Вчера" -> вчерашняя дата, время 00:00
//        "01:01" -> сегодняшняя дата, указанное время
//        "01:01:01" -> сегодняшняя дата, указанное время
//        "2024.01.01" -> указанная дата, время 00:00
//        "2024.01.01, 22:10" -> указанная дата и время
//        "2024.01.01, 22:10:15" -> указанная дата и время
//        "1 янв 2024" -> указанная дата, время 00:00
//        "1 янв 2024, 22:10" -> указанная дата и время
//        "1 янв 2024, 22:10:15" -> указанная дата и время

        private val zeroTime = LocalTime.MIDNIGHT

        @JvmStatic
        fun provideArguments(): List<Arguments> = listOf(
            Arguments.of("Today", LocalDateTime.now().with(zeroTime)),
            Arguments.of("Yesterday", LocalDateTime.now().minusDays(1).with(zeroTime)),
            Arguments.of("Tomorrow", LocalDateTime.now().plusDays(1).with(zeroTime)),
            Arguments.of("01:01", LocalDateTime.now().with(LocalTime.of(1,1))),
            Arguments.of("01:01:01", LocalDateTime.now().with(LocalTime.of(1,1, 1))),
            Arguments.of("2024.01.01", LocalDateTime.of(2024, 1, 1, 0, 0)),
            Arguments.of("2024.01.01, 22:10", LocalDateTime.of(2024, 1, 1, 22, 10)),
            Arguments.of("2024.01.01, 22:10:15", LocalDateTime.of(2024, 1, 1, 22, 10, 15)),
            Arguments.of("1 янв. 2024", LocalDateTime.of(2024, 1, 1, 0, 0)),
            Arguments.of("1 янв. 2024, 22:10", LocalDateTime.of(2024, 1, 1, 22, 10)),
            Arguments.of("1 янв. 2024, 22:10:15", LocalDateTime.of(2024, 1, 1, 22, 10, 15)),
        )

    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    fun checkConverter(time: String, expectedResult: LocalDateTime) {
        Assertions.assertEquals(expectedResult, converter.convertToDateTime(time))
    }

    @Test
    fun `throw exception at 2023 02 29`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            converter.convertToDateTime("29 фев. 2023")
        }
    }

}