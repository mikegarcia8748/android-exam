package com.example.androidtechnicalexamination.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class DefaultInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Accept", "Application/json")
        return chain.proceed(builder.build())
    }
}