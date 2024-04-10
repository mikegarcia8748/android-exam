package com.example.androidtechnicalexamination.ui.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtechnicalexamination.data.remote.Resource
import com.example.androidtechnicalexamination.data.remote.repository.UsersRepository
import com.example.androidtechnicalexamination.data.room.user.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    private val errorMessage: MutableLiveData<String> = MutableLiveData("")
    private val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    private val isRefreshing: MutableLiveData<Boolean> = MutableLiveData(false)

    init {
        importUserList()
    }

    fun getErrorMessage() : LiveData<String> {
        return errorMessage
    }

    fun getUserListForPreview() : LiveData<List<UserEntity>> {
        return repository.getUsersList()
    }

    fun isLoading() : LiveData<Boolean> {
        return isLoading
    }
    fun isRefreshing() : LiveData<Boolean> {
        return isRefreshing
    }

    private fun importUserList() {
        viewModelScope.launch {

            // Validate if the local cache has existing records of users...
            val hasUsers = repository.getUsers().isNotEmpty()
            if (!hasUsers) {
                repository.importUsersList().collect { response ->
                    when (response) {
                        is Resource.Success -> {
                            isLoading.value = false

                            response.data?.results?.forEach { result ->

                                val firstName = result?.name?.first
                                val lastName = result?.name?.last

                                val personEntity = UserEntity(
                                    firstName = firstName,
                                    lastName = lastName,
                                    birthday = result?.dob?.date,
                                    emailAddress = result?.email,
                                    mobileNo = result?.cell,
                                    address = "",
                                    street = result?.location?.street?.name,
                                    number = result?.location?.street?.number,
                                    city = result?.location?.city,
                                    state = result?.location?.state,
                                    country = result?.location?.country,
                                    postCode = result?.location?.postcode,
                                    longitude = result?.location?.coordinates?.longitude,
                                    latitude = result?.location?.coordinates?.latitude,
                                    timeZone = result?.location?.timezone?.offset,
                                    timeZoneDescription = result?.location?.timezone?.description,
                                    contactPerson = "$firstName $lastName", // Contact Person and Mobile No for contact person doesn't exist in the data provided by the API...
                                    contactPersonMobileNo = result?.cell, // Contact Person and Mobile No for contact person doesn't exist in the data provided by the API...
                                    largeImage = result?.picture?.large,
                                    mediumImage = result?.picture?.large,
                                    thumbnail = result?.picture?.large,
                                )
                                repository.savePerson(personEntity)
                            }
                        }

                        is Resource.Loading -> {
                            isLoading.value = true
                        }

                        // Error Handling...
                        else -> {
                            isLoading.value = false
                            errorMessage.value = response.error?.message
                        }
                    }
                }
            }
        }
    }


    fun refreshUserList() {
        viewModelScope.launch {

            repository.clearUserCache()

            repository.importUsersList().collect { response ->
                when (response) {
                    is Resource.Success -> {
                        isRefreshing.value = false

                        response.data?.results?.forEach { result ->
                            val personEntity = UserEntity(
                                firstName = result?.name?.first,
                                lastName = result?.name?.last,
                                birthday = result?.dob?.date,
                                emailAddress = result?.email,
                                mobileNo = result?.cell,
                                address = "",
                                street = result?.location?.street?.name,
                                number = result?.location?.street?.number,
                                city = result?.location?.city,
                                state = result?.location?.state,
                                country = result?.location?.country,
                                postCode = result?.location?.postcode,
                                longitude = result?.location?.coordinates?.longitude,
                                latitude = result?.location?.coordinates?.latitude,
                                timeZone = result?.location?.timezone?.offset,
                                timeZoneDescription = result?.location?.timezone?.description,
                                contactPerson = response.data.info?.seed,
                                contactPersonMobileNo = response.data.info?.seed,
                                largeImage = result?.picture?.large,
                                mediumImage = result?.picture?.large,
                                thumbnail = result?.picture?.large,
                            )
                            repository.savePerson(personEntity)
                        }
                    }

                    is Resource.Loading -> {
                        isRefreshing.value = true
                    }

                    // Error Handling...
                    else -> {
                        isRefreshing.value = false
                        errorMessage.value = response.error?.message
                    }
                }
            }
        }
    }
}