package com.example.androidtechnicalexamination.data.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Timezone(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("offset")
    val offset: String? = null
)