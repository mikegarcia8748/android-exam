package com.example.androidtechnicalexamination.data.room.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsersDao {

    @Query("DELETE FROM User_Info")
    fun clearUserCache()

    @Query("SELECT * FROM User_Info")
    fun getUsers() : List<UserEntity>

    @Query("SELECT * FROM User_Info WHERE uid=:uid")
    fun getUserDetail(uid: String) : LiveData<UserEntity>

    @Query("SELECT * FROM User_Info ")
    fun getUsersList(): LiveData<List<UserEntity>>

    @Insert
    fun savePerson(persons: UserEntity)
}