package com.example.androidtechnicalexamination.data.remote.repository

import androidx.lifecycle.LiveData
import com.example.androidtechnicalexamination.data.remote.ApiService
import com.example.androidtechnicalexamination.data.remote.networkBounceResource
import com.example.androidtechnicalexamination.data.room.user.UsersDao
import com.example.androidtechnicalexamination.data.room.user.UserEntity
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val api: ApiService,
    private val userDao: UsersDao
) {

    fun getUsers() : List<UserEntity> {
        return userDao.getUsers()
    }

    fun getUsersList() : LiveData<List<UserEntity>> {
        return userDao.getUsersList()
    }

    fun importUsersList() = networkBounceResource(
        fetch = {
            api.getUsersList()
        }
    )

    fun savePerson(personEntity: UserEntity) = userDao.savePerson(personEntity)

    fun clearUserCache() {
        userDao.clearUserCache()
    }

    fun getUserDetail(uid: String) = userDao.getUserDetail(uid)
}