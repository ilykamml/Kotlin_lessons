package ru.ilyamnl.lessons

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PhoneFormatterTest {

    private val formatter = PhoneFormatter()

    companion object {

        @JvmStatic
        fun provideArguments() = listOf(
            Arguments.of("8 (922) 941-11-11", "+7 (922) 941-11-11"),
            Arguments.of("79229411111", "+7 (922) 941-11-11"),
            Arguments.of("+7 922 941 11 11", "+7 (922) 941-11-11"),
            Arguments.of("9229411111", "+7 (922) 941-11-11"),
            Arguments.of("12345", null),
            Arguments.of("abc +7 922 941 11 11", "+7 (922) 941-11-11"),
            Arguments.of("+1 (922) 941-11-11", null),
            Arguments.of("+7 (922) 941-11", null),
        )
    }

//    - `8 (922) 941-11-11` -> `+7 (922) 941-11-11`
//    - `79229411111` -> `+7 (922) 941-11-11`
//    - `+7 922 941 11 11` -> `+7 (922) 941-11-11`
//    - `9229411111` -> `+7 (922) 941-11-11`
//    - `12345` -> `null` (невалидный номер)
//    - `abc +7 922 941 11 11` -> `null` (невалидный начальный символ)
//    - `+1 (922) 941-11-11` -> `null` (невалидный код страны)


    @ParameterizedTest
    @MethodSource("provideArguments")
    fun formatPhoneNumber(phone: String, expected: String?) =
        Assertions.assertEquals(expected, formatter.formatPhoneNumber(phone))
}