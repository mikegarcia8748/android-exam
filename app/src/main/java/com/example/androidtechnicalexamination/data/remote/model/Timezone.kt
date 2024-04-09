package com.example.androidtechnicalexamination.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Timezone(
    @SerialName("description")
    val description: String?,
    @SerialName("offset")
    val offset: String?
)