package com.example.androidtechnicalexamination.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Id(
    @SerialName("name")
    val name: String?,
    @SerialName("value")
    val value: String?
)