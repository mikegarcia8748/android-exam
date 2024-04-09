package com.example.androidtechnicalexamination.data.remote.repository

import com.example.androidtechnicalexamination.data.remote.ApiService
import com.example.androidtechnicalexamination.data.remote.networkBounceResource
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val api: ApiService
) {

    fun getPersonList() = networkBounceResource(
        fetch = {
            api.getPersonList()
        }
    )
}