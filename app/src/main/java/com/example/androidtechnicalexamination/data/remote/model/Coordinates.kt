package com.example.androidtechnicalexamination.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Coordinates(
    @SerialName("latitude")
    val latitude: String?,
    @SerialName("longitude")
    val longitude: String?
)