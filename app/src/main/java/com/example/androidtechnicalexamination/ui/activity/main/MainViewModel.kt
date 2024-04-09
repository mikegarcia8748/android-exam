package com.example.androidtechnicalexamination.ui.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtechnicalexamination.data.remote.Resource
import com.example.androidtechnicalexamination.data.remote.repository.PersonRepository
import com.example.androidtechnicalexamination.data.room.person.PersonEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val personRepository: PersonRepository
) : ViewModel() {

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    private val errorMessage: MutableLiveData<String> = MutableLiveData("")
    private val personList: MutableLiveData<List<PersonEntity>> = MutableLiveData(emptyList())

    init {
        importPersonList()
    }

    fun getErrorMessage() : LiveData<String> {
        return errorMessage
    }

    fun getPersonList() : LiveData<List<PersonEntity>> {
        return personList
    }

    fun isLoading() : LiveData<Boolean> {
        return isLoading
    }

    private fun importPersonList() {
        viewModelScope.launch {
            personRepository.getPersonList().collect { response ->
                when (response) {
                    is Resource.Success -> {

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