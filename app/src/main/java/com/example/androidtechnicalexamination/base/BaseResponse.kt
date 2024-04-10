package com.example.androidtechnicalexamination.base

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Keep
@Serializable
data class BaseResponse<T>(
    @SerialName("result")
    val data: T? = null,
    @SerialName("message")
    val message: String?
)