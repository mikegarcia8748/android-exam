package com.example.androidtechnicalexamination.data.room.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_Info")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long = 0,
    @ColumnInfo(name = "FirstName") val firstName: String?,
    @ColumnInfo(name = "LastName") val lastName: String?,
    @ColumnInfo(name = "Birthday") val birthday: String?,
    @ColumnInfo(name = "EmailAddress") val emailAddress: String?,
    @ColumnInfo(name = "MobileNo") val mobileNo: String?,
    @ColumnInfo(name = "Address") val address: String?,
    @ColumnInfo(name = "Street") val street: String?,
    @ColumnInfo(name = "Number") val number: String?,
    @ColumnInfo(name = "City") val city: String?,
    @ColumnInfo(name = "State") val state: String?,
    @ColumnInfo(name = "Country") val country: String?,
    @ColumnInfo(name = "PostCode") val postCode: String?,
    @ColumnInfo(name = "Longitude") val longitude: String?,
    @ColumnInfo(name = "Latitude") val latitude: String?,
    @ColumnInfo(name = "TimeZone") val timeZone: String?,
    @ColumnInfo(name = "TimeZone_Description") val timeZoneDescription: String?,
    @ColumnInfo(name = "ContactPerson") val contactPerson: String?,
    @ColumnInfo(name = "ContactPersonMobileNo") val contactPersonMobileNo: String?,
    @ColumnInfo(name = "LargeImage") val largeImage: String?,
    @ColumnInfo(name = "MediumImage") val mediumImage: String?,
    @ColumnInfo(name = "Thumbnail") val thumbnail: String?
)
