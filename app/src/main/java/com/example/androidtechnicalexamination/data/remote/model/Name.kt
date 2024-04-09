package com.example.androidtechnicalexamination.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Name(
    @SerialName("first")
    val first: String?,
    @SerialName("last")
    val last: String?,
    @SerialName("title")
    val title: String?
)