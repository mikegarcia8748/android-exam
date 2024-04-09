package com.example.androidtechnicalexamination.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Location(
    @SerialName("city")
    val city: String?,
    @SerialName("coordinates")
    val coordinates: Coordinates?,
    @SerialName("country")
    val country: String?,
    @SerialName("postcode")
    val postcode: String?,
    @SerialName("state")
    val state: String?,
    @SerialName("street")
    val street: Street?,
    @SerialName("timezone")
    val timezone: Timezone?
)