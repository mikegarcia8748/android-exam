package com.example.androidtechnicalexamination.data.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Info(
    @SerializedName("page")
    val page: String? = null,
    @SerializedName("results")
    val results: String? = null,
    @SerializedName("seed")
    val seed: String? = null,
    @SerializedName("version")
    val version: String? = null
)