package com.example.androidtechnicalexamination.data.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Street(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("number")
    val number: String? = null
)