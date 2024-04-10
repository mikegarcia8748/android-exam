package com.example.androidtechnicalexamination.data.remote

import com.example.androidtechnicalexamination.data.remote.model.UsersModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api/?results=20")
    suspend fun getUsersList(): Response<UsersModel>
}