package com.example.androidtechnicalexamination.data.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Dob(
    @SerializedName("age")
    val age: String? = null,
    @SerializedName("date")
    val date: String? = null
)