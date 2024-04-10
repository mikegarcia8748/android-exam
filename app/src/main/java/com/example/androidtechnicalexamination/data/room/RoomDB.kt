package com.example.androidtechnicalexamination.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtechnicalexamination.data.room.user.UsersDao
import com.example.androidtechnicalexamination.data.room.user.UserEntity

@Database(entities = [
        UserEntity::class],
    version = 1)
abstract class RoomDB: RoomDatabase() {

    abstract fun personDao(): UsersDao
}