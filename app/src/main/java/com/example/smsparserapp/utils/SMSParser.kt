package com.example.smsparserapp.utils

import com.example.smsparserapp.models.SMSData
import java.text.SimpleDateFormat
import java.util.*

object SmsParser {

    fun parseSMS(smsText: String): SMSData? {
        val regex = """debited with ETB (\d{1,3}(,\d{3})*(\.\d{2})?) on (\d{2}/\d{2}/\d{4}) at (\d{2}:\d{2}).*current balance is ETB (\d{1,3}(,\d{3})*(\.\d{2})?)""".toRegex()
        val matchResult = regex.find(smsText)

        return if (matchResult != null) {
            val amount = matchResult.groupValues[1].replace(",", "").toDouble()
            val dateStr = matchResult.groupValues[4]
            val time = matchResult.groupValues[5]
            val balance = matchResult.groupValues[6].replace(",", "").toDouble()

            val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(dateStr) ?: Date()

            SMSData(
                date = date,
                bankName = "Commercial Bank of Ethiopia",
                time = time,
                transactionType = "debit",
                amount = amount,
                balance = balance
            )
        } else {
            null
        }
    }
}
