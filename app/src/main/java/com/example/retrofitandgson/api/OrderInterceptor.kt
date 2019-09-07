package com.example.retrofitandgson.api

import okhttp3.Interceptor
import okhttp3.Response

class OrderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl
            .newBuilder()
            .addQueryParameter("_sort", "id")
            .addQueryParameter("_order", "desc")
            .build()
            .takeIf { originalRequest.method.equals("GET", ignoreCase = true) }
            ?: originalUrl

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }


}