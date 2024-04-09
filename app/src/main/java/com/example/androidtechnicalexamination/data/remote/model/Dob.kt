package com.example.androidtechnicalexamination.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Dob(
    @SerialName("age")
    val age: Int?,
    @SerialName("date")
    val date: String?
)