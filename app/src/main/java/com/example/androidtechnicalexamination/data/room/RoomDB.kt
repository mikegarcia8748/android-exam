package com.example.androidtechnicalexamination.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtechnicalexamination.data.room.person.PersonDao
import com.example.androidtechnicalexamination.data.room.person.PersonEntity

@Database(entities = [
        PersonEntity::class],
    version = 1)
abstract class RoomDB: RoomDatabase() {

    abstract fun personDao(): PersonDao
}