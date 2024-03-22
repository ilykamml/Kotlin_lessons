package ru.ilyamnl.homework

import java.time.LocalDate

class Hackathon(
    pwd: String,
    name: String,
    date: LocalDate,
    location: String,
    detailedBudget: String,
    members: Int,
    membersLimit: Int,
    duration: String,
    documents: String,
    status: String,
    sponsors: String,
    budget: Float,
    internetLevel: String,
    logistics: String,
    teamsNum: Int,
    tasks: String,
    evacuation: String,
    equipList: String,
    expertsList: String,
    analyticsMethod: String,
    privacyPolicy: String
) {

    private val password: String = pwd
    val eventName: String = name
    val eventDate: LocalDate = date
    val eventLocation: String = location
    private val eventBudgetDetailed: String by lazy {
        detailedBudget
    }
    var numberOfParticipants: Int = members
        private set
    val participantsLimit: Int = membersLimit
    val eventDuration: String = duration
    private val eventDocs: String by lazy {
        documents
    }
    var currentStatus: String = status
        private set
    val eventSponsors: String by lazy {
        sponsors
    }
    private val eventBudget: Float = budget
    var currentLevelOfInternet: String = internetLevel
    private var logisticsInfo: String = logistics
    var numberOfTeams: Int = teamsNum // private set чтобы команды записывались через форму обработки, чтобы не было переполнения по участникам
        private set
    var tasksList: String = tasks
        private set
    val evacuationPlan: String = evacuation
    val equipmentList: String = equipList
    var freeEquipmentList: String = equipList // участники могут брать оборудование и сами записывать
    private lateinit var participantsMealSchedule: String
    private lateinit var planIfWeHaveSomeFailures: String
    val listOfExperts: String = expertsList
    private val methodsOfAnalytics: String = analyticsMethod
    val privacyPolicyDoc: String = privacyPolicy
    private var privateFeedback: String = ""
    var currentTemp: Float = 24f
    private var networkStatus: Boolean = true
    var lightingLevel: String = "good"
    private var eventLog: String = ""





    private fun getAccess(key: String): Boolean { // функция проверки "кода доступа"
        return key == password
    }

    fun getFullEventBudget(key: String = ""): String { // получение данных о детальном бюджете
        if (getAccess(key)) return eventBudgetDetailed
        return "Denied"
    }

    private fun addParticipants(number: Int) { // добавление количества участников с проверкой на переполнение
        numberOfParticipants + number.apply {
            if (this <= participantsLimit) {
                numberOfParticipants += number
            }
        }
    }

    fun getEventDocs(key: String = ""): String { // получение контактной информации и условий соглашения с поставщиками.. Документы
        if (getAccess(key)) return eventDocs
        return "Denied"
    }

    fun setEventStatus(status: String, key: String = "") { // установка статуса хакатона
        if (getAccess(key)) {
            currentStatus = status
        }
    }

    fun getEventBudget(key: String = ""): String { // получение данных о цифре бюджета
        if (getAccess(key)) return "$eventBudget"
        return "Denied"
    }

    fun getLogisticInfo(key: String = ""): String { // получение данных о логистике, распределении ресурсови координации
        if (getAccess(key)) return logisticsInfo
        return "Denied"
    }

    fun addLogisticInfo(info: String, key: String = "") { // добавление данных о логистике...
        if (getAccess(key)) {
            logisticsInfo += info
        }
    }

    fun addTeam(numOfMembersInTeam: Int) { // добавление команды с последующей записью количества новых человек в общей куче людей
        if (numOfMembersInTeam + numberOfParticipants <= participantsLimit) {
            numberOfTeams++
            addParticipants(numberOfTeams)
        }
    }

    fun setTasksList(newTasks: String, key: String = "") { // запись тасков на хакатон
        if (getAccess(key)) {
            tasksList = newTasks
        }
    }

    fun setParticipantsMealSchedule(schedule: String, key: String = "") { // запись расписания еды для участников
        if (getAccess(key)) {
            participantsMealSchedule = schedule
        }
    }

    fun getMealSchedule(): String { // получение раписания еды
        if (::participantsMealSchedule.isInitialized) return participantsMealSchedule
        return ""
    }

    fun setFailurePlan(plan: String, key: String = "") { // запись плана мероприятий на случай сбоя
        if (getAccess(key)) planIfWeHaveSomeFailures = plan
    }

    fun getPlanIfFailure(): String { // получение плана мероприятий на случай сбоя
        if (::participantsMealSchedule.isInitialized) return planIfWeHaveSomeFailures
        return ""
    }

    fun getMethodsOfAnalytics(key: String): String { // получить методичку по сбору отзывов etc
        if (getAccess(key)) return methodsOfAnalytics
        return "Denied"
    }

    fun getPrivateFeedback(key: String): String { // получить данные к приватному фидбэку
        if (getAccess(key)) return privateFeedback
        return "Denied"
    }

    fun addPrivateFeedback(feedback: String) { // оставить отзыв
        privateFeedback += "\n$feedback"
    }

    fun getNetworkStatus(): String { // получить network статус
        return "$networkStatus"
    }

    fun setNetworkStatus(status: Boolean, key: String = "") { // задать network статус
        if (getAccess(key)) networkStatus = status
    }

    fun addEventLog(status: String, key: String = "") { // добавить запись в лог
        if (getAccess(key)) eventLog += "\n$status"
    }

    fun getEventLog(key: String = ""): String { // прочитать лог
        if (getAccess(key)) return eventLog
        return "Denied"
    }

}

fun main() {

    val a: Hackathon = Hackathon(
        "al0h0m0ra",
        "Microthon",
        LocalDate.of(2023, 12, 3),
        "Kokshetau",
        "Equipment: 10.000$, Catering: 3.000$, Rent: 500$, Prize fund: 50.000$, Little things: 4.000$",
        0,
        1500,
        "3 days",
        "important documents",
        "Not started",
        "Long sponsors list",
        67500f,
        "Good",
        "important logistic info",
        0,
        "1 - abs work, 2 - ran, 3 - pul ap. 4 pus aps",
        "Go away from building",
        "5 laptops, 2 tv's, 3 projectors",
        "Bob, Bib, Bub",
        "Take a survey on a dinner",
        "Privacy Policy Doc"
    )
    println(a.getFullEventBudget("al0h0m0ra"))
    println(a.getEventDocs("al0h0m0ra"))

}
