package com.example.androidtechnicalexamination.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Picture(
    @SerialName("large")
    val large: String?,
    @SerialName("medium")
    val medium: String?,
    @SerialName("thumbnail")
    val thumbnail: String?
)