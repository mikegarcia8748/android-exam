package com.example.androidtechnicalexamination.ui.activity.persondetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidtechnicalexamination.data.remote.repository.UsersRepository
import com.example.androidtechnicalexamination.data.room.user.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PersonDetailViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    fun getUserDetail(uid: String) : LiveData<UserEntity> {
        return repository.getUserDetail(uid)
    }
}