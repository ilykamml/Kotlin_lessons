# Дорожная карта по изучению Kotlin

## Основы Kotlin:
- Переменные: `val`, `var`
- Типы данных: `Int`, `String`, `Float`, `Boolean`, `Array`, `List`, `Map`, `Set`
- Операторы: арифметические, сравнения, логические
- Условные операторы: `if`, `when`
- Циклы: `for`, `while`, `do-while`
- Функции: объявление функций, параметры функций, возвращаемые значения
- Nullability: nullable типы, операторы `?.`, `?:`, `!!`
- Исключения: `try/catch/finally`, `throw`
- Строки: строки, шаблоны строк, тройные кавычки
- Массивы и коллекции: `Array`, `List`, `Set`, `Map`

## Объектно-ориентированное программирование (ООП) в Kotlin:
- Классы и объекты:
    - Создание классов: классы, объекты, компаньоны
    - Конструкторы: первичные, вторичные
    - Свойства и методы: свойства, функции, расширения
    - Наследование: базовые классы, производные классы, `open`, `override`, `final`
- Полиморфизм:
    - Переопределение методов
    - Абстрактные классы и интерфейсы: `abstract`, `interface`
    - Абстракция и инкапсуляция: модификаторы доступа (`private`, `public`, `protected`, `internal`), геттеры и сеттеры
    - Data классы: автоматические `equals()`, `hashCode()`, `copy()`
    - Sealed классы: ограниченное наследование
    - Объекты: объекты, компаньоны, object expressions
    - Вложенные и внутренние классы
    - Анонимные объекты

## Функциональное программирование в Kotlin:
- Лямбда-выражения: синтаксис, использование
- Функции высшего порядка: передача функций как параметров, возвращение функций
- Функциональные интерфейсы: `Functor`, `Applicative`, `Monad`

## Коллекции и обобщения в Kotlin:
- Коллекции: `List`, `Set`, `Map`, функции коллекций (`filter`, `map`, `reduce` и т.д.)
- Обобщения:
    - Обобщённые классы: классы с параметрами типа
    - Обобщённые функции: функции с параметрами типа
    - Ограничения типов: `where`, `out`, `in`
    - Коллекции: `MutableList`, `MutableSet`, `MutableMap`
    - Обобщения: звёздочные проекции

## Kotlin Coroutines:
- Основы корутин: `launch`, `suspend`, `async`, `await`
- Обработка ошибок в корутинах: `try/catch`, `CoroutineExceptionHandler`
- Контексты и диспетчеры корутин: `Dispatchers.Main`, `Dispatchers.IO`, `Dispatchers.Default`
- Channels: создание, отправка, получение
- Coroutine Scope: `lifecycle`, `SupervisorJob`

## Kotlin Flow API:
- Основы Flow: создание, коллекторы, операторы (`map`, `filter`, `reduce` и т.д.)
- Обработка ошибок в Flow: `catch`, `onCompletion`
- Hot и Cold Flow: `SharedFlow`, `StateFlow`
- Backpressure: `buffer`, `conflate`, `collectLatest`

## Jetpack Compose:
- Основы Compose: `@Composable` функции, модификаторы, состояние
- Макеты в Compose: `Row`, `Column`, `Box`, `ConstraintLayout`
- Навигация в Compose: `NavController`, `rememberNavController`, `NavHost`
- Состояние в Compose: `mutableStateOf`, `remember`
- Взаимодействие с состоянием: `onValueChange`, `onValueChangeFinished`
- Анимации в Compose: `animateContentSize`, `Crossfade`
