package com.example.androidtechnicalexamination.extension

import android.annotation.SuppressLint
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Locale

@SuppressLint("NewApi")
fun String.getAge(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val parsedDate = LocalDate.parse(this, formatter)

    // Calculate the age based on the birthdate
    val currentDate = LocalDate.now()
    val age = Period.between(parsedDate, currentDate).years

    return age.toString()
}

@SuppressLint("NewApi")
fun String.toUiPreview(): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date = LocalDateTime.parse(this, formatter)

        // Convert to the desired output format
        val outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH)
        date.atOffset(ZoneOffset.UTC).format(outputFormatter)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}