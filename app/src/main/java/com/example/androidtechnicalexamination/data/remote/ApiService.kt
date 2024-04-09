package com.example.androidtechnicalexamination.data.remote

import com.example.androidtechnicalexamination.data.remote.model.PersonModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api")
    suspend fun getPersonList(): Response<PersonModel>
}