package com.example.androidtechnicalexamination.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Street(
    @SerialName("name")
    val name: String?,
    @SerialName("number")
    val number: Int?
)