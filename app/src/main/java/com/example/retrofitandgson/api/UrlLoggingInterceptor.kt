package com.example.retrofitandgson.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class UrlLoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val url = response.headers("location").firstOrNull()
        Log.d("UrlLoggingInterceptor", "INTERCEPTED : ${url.toString()}")
        return response
    }
}