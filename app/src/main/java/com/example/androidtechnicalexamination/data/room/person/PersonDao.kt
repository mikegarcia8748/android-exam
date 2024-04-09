package com.example.androidtechnicalexamination.data.room.person

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {

    @Insert
    fun savePersons(persons: List<PersonEntity>)

    @Query("SELECT * FROM Person_Info ")
    fun getPersonList(): List<PersonEntity>
}