package com.example.androidtechnicalexamination.data.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Location(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("coordinates")
    val coordinates: Coordinates? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("postcode")
    val postcode: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("street")
    val street: Street? = null,
    @SerializedName("timezone")
    val timezone: Timezone? = null
)