package com.example.androidtechnicalexamination.data.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Result(
    @SerializedName("cell")
    val cell: String? = null,
    @SerializedName("dob")
    val dob: Dob? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("id")
    val id: Id? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("login")
    val login: Login? = null,
    @SerializedName("name")
    val name: Name? = null,
    @SerializedName("nat")
    val nat: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("picture")
    val picture: Picture? = null,
    @SerializedName("registered")
    val registered: Registered? = null
)