package com.example.androidtechnicalexamination.data.remote

import com.example.androidtechnicalexamination.data.remote.model.PersonModel
import retrofit2.Response
import retrofit2.http.POST

interface ApiService {

    @POST("/api/")
    suspend fun getPersonList(): Response<List<PersonModel>>
}