package com.example.androidtechnicalexamination.data.room.person

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person_Info")
data class PersonEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "FirstName") val firstName: String?,
    @ColumnInfo(name = "LastName") val lastName: String?,
    @ColumnInfo(name = "Birthday") val birthday: String?,
    @ColumnInfo(name = "EmailAddress") val emailAddress: String?,
    @ColumnInfo(name = "MobileNo") val mobileNo: String?,
    @ColumnInfo(name = "Address") val address: String?,
    @ColumnInfo(name = "ContactPerson") val contactPerson: String?,
    @ColumnInfo(name = "ContactPersonMobileNo") val contactPersonMobileNo: String?
)
