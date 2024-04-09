package com.example.androidtechnicalexamination.data.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class UsersModel(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("results")
    val results: List<Result?>? = null
)