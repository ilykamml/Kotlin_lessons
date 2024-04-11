package ru.ilyamnl.lessons

class PhoneFormatter {

    fun formatPhoneNumber(phoneNumber: String): String? {

        // pattern -> +7 (XXX) XXX-XX-XX
        if (phoneNumber.isEmpty()) return null

        val cleanedPhone = phoneNumber
            .replace("\\D".toRegex(), "")
            .replace("^9".toRegex(), "+79")
            .replace("^[7, 8]".toRegex(), "+7")

        if (cleanedPhone.startsWith("+7") && cleanedPhone.length == 12) {
            val firstFragment = cleanedPhone.substring(0, 2)
            val secondFragment = cleanedPhone.substring(2, 5)
            val thirdFragment = cleanedPhone.substring(5, 8)
            val fourthFragment = cleanedPhone.substring(8, 10)
            val fifthFragment = cleanedPhone.substring(10)

            return "%s (%s) %s-%s-%s".format(firstFragment, secondFragment, thirdFragment, fourthFragment, fifthFragment)
        } else return null

    }

}