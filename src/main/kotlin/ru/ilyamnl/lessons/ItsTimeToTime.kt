package ru.ilyamnl.lessons

import java.time.*
import java.time.format.DateTimeFormatter
import javax.swing.text.DateFormatter

fun main() {

    val instant = Instant.now() // Метка времени. Отсчёт начинается с эпохи Unix. От 01.01.1970 00:00:00 UTC+0
    println(instant)
    // обычно не используют или используют в логгировании

    val dateTimeNow = LocalDate.now() // Местное время, не храним часовой пояс. Date - только дата
    println(dateTimeNow)

    val birthday = LocalDate.of(1983, 10, 2)

    val localTimeNow = LocalTime.now() // Не храним часовой пояс и храним только время. Время есть, а даты - нет
    println(localTimeNow)
    // тоже есть .of

    val localDateTime = LocalDateTime.now()
    println(localDateTime)
    // тоже есть .of
    val dateTime = LocalDateTime.of(dateTimeNow, localTimeNow)
    println(dateTime)

    val vaticanCurrentTime = ZonedDateTime.now((ZoneId.of("Europe/Vatican")))
    println(vaticanCurrentTime)
    // учитывает стандартное и летнее время
    // также есть .of

    val birthdayInDubai = OffsetDateTime.of(birthday.atTime(19, 0), ZoneOffset.of("+09:00"))
    println(birthdayInDubai)
    // смещение от UTC

    val vaticanCurrentTimeInstant = vaticanCurrentTime.toInstant()
    println(vaticanCurrentTimeInstant)
    // не сможем работать с зонами

    val birthdayInstant = birthday.atTime(19, 0).toInstant(ZoneOffset.of("+09:00"))
    println(birthdayInstant)
    // чтобы перевести в instant нужно перевести в UTC

    val instantToZonedDateTime = instant.atZone(ZoneId.systemDefault())
    println(instantToZonedDateTime)
    // инстант в зонированную дату

    val instantToOffsetDateTime = instant.atOffset((ZoneOffset.of("-02:00")))
    println(instantToOffsetDateTime)

    println(LocalDate.now().plusYears(1)) // прибавляем один год
    println(LocalDateTime.now().minusSeconds(24523)) // убираем секунды

    println(Period.between(birthday, LocalDate.now()))
    println(Duration.between(birthday.atTime(19, 0), LocalDateTime.now()))

    // Есть alarmClock.plus(5, ChronoUnit.MINUTES) - позволяет прибавлять время

    // с Duration можно считать длительность операций
    // Period считает только в днях и более, учитывается все правки


    // ФОРМАТИРОВАНИЕ И ПАРСИНГ

    // DateTimeFormatter.ofPattern("pattern")
    // time.format(DateTimeFormatter)

    // val parsedDate = LocalDate.parse(prettyFormattedDate, prettyFormatter)
    // println(parsedDate) -> 2024-03-25

    // PRACTICE

    val currentTimeStamp = Instant.now()

    val timeStamp2 = Instant.ofEpochMilli(342590839048)
    println(timeStamp2)

    val dayOfKnowledge = LocalDate.of(2024, 9, 1)

    val lastDayOfSpring = LocalDate.of(2025, 5, 31)

    val periodBetweenKnowledgeAndLastDayOfSpring = Period.between(dayOfKnowledge, lastDayOfSpring)
    println(periodBetweenKnowledgeAndLastDayOfSpring)

    val periodNumberTwo = Period.of(2, 300, 300)

    val periodFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    println(lastDayOfSpring.plus(periodNumberTwo).format(periodFormatter)) // ФОРМАТИРОВАНИЕ ДАТЫ НА ПРИМЕРЕ

    val planSprint = ZonedDateTime.of(2024, 4, 1, 10, 0, 0, 0, ZoneId.of("Europe/Moscow"))
    println(planSprint)

    val planFormatter = DateTimeFormatter.ofPattern("yyyy 'Гот' MMMM 'МесяцЗа' dd 'Дзень', HH 'Часы' mm 'Минутки'")
    println(planSprint.withZoneSameInstant(ZoneOffset.of("+07:00")).format(planFormatter))
    println(planSprint.plusDays(11).plusHours(5).withZoneSameInstant(ZoneOffset.of("+07:00")).format(planFormatter))

    println(Period.of(1, 11, 25).multipliedBy(4))

}