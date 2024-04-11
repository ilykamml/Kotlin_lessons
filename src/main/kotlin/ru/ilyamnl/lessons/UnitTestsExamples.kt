package ru.ilyamnl.lessons

// юнит тест - тестирует один элемент (метод)
// конкретность, быстрота, повторяемость, автономность
// микроскопический тест
// их может быть очень много

// тестируемость приложения == свойство кода, облегчающее написание юнит тестов
// принцип солид - принцип единой ответственности (объект должен выполнять что-то одно)
// паттерны проектирования - сложная штука, для проектирования архитектуры приложения
// инверсии зависимостей - когда вместо классов используем интерфейсы (в качестве аргумента функции мы указываем интерфейс и можем передавать туда разные реализации интерфейса)

// @BeforeEach - до запуска каждого теста (setUp)
// @AfterEach - после каждого теста (tearDown)
// @BeforeAll - перед запуском всех тестов - должны быть в companion object
// @AfterAll - после запуска всех тестов - должны быть в companion object
// @Test - тест. Запускается в рандомном порядке
// companion object - отдельный класс в единственном экземпляре, сохраняет свою конфигурацию на протяжении всех тестов


// Assertions.assertEquals(expected = 4, actual=testList.size, message="list should be ...")
// assertTrue(!testList.isEmpty())
// assertFalse(testList.isEmpty())
// assertAll - принимает в себя набор ассертов, и потом показываются ассерты, которые упали
// assertArrayEquals - массивы. Сравниваются поэлементно
// assertTrows - метод должен вызвать исключение
// assertDoesNotThrow - метод не должен выкидывать исключение
// assertInstanceOf - объект должен быть определённого типа
// assertTimeout - указываем duration и передаём функцию. Если исполняется дольше таймаута - вызовет исключение

// Параметризованные тесты
//@ParameterizedTest
//@ValueSource(strings = ["test@example.com", "valid+email@example.uk.co"])
// fun `valid emails should return true`(email: String) = assertTrue(validator.isValid(email))


//@MethodSource("emailSource") - метод должен быть статичный (companion object -> @JvmStatic -> fun emailSource())

// class MyClass {
// companion object {
// @JvmStatic
// fun mySource() = listOf(Arguments.of("string", true), Arguments.of("string2", false))
//}
//@ParameterizedTest
//@MethodSource("mySource")
//fun test(string: String, valid: Boolean) = assertEquals(isValid, TestedClass.method(string))

//@CsvSource - передаём туда табличку аргументов
//@EnumSource(CoffeeType::class) - принимает в качестве аргумента тип enum
//@CsvFileSource - передаём туда путь до файла с табличкой (или нескольких файлов)
// И многие другие

