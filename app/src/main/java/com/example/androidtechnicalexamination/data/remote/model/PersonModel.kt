package com.example.androidtechnicalexamination.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class PersonModel(
    @SerialName("cell")
    val cell: String?,
    @SerialName("dob")
    val dob: Dob?,
    @SerialName("email")
    val email: String?,
    @SerialName("gender")
    val gender: String?,
    @SerialName("id")
    val id: Id?,
    @SerialName("location")
    val location: Location?,
    @SerialName("login")
    val login: Login?,
    @SerialName("name")
    val name: Name?,
    @SerialName("nat")
    val nat: String?,
    @SerialName("phone")
    val phone: String?,
    @SerialName("picture")
    val picture: Picture?,
    @SerialName("registered")
    val registered: Registered?
)