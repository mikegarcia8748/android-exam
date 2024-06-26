package com.example.androidtechnicalexamination.data.remote

import kotlinx.coroutines.flow.flow
import retrofit2.Response
import timber.log.Timber

inline fun<T> networkBounceResource(
    crossinline fetch: suspend () -> Response<T>
) = flow {

    emit(Resource.Loading(null))

    try{
        val data = fetch()
        val body = data.body()

        if (data.isSuccessful) {
            emit(Resource.Success(body))
        } else {
            val throwable = Throwable(message = "An error has occurred! Please try again later.")
            Timber.e(throwable)
            emit(Resource.Error(throwable, null))
        }
    } catch (throwable: Throwable) {
        Timber.e(throwable)
        emit(Resource.Error(throwable, null))
    }
}