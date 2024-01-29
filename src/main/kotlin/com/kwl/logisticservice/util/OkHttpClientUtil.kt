package com.kwl.logisticservice.util

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpClientUtil {
    val client = OkHttpClient.Builder()
        .connectTimeout(10,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(10,TimeUnit.SECONDS)
        .connectionPool(okhttp3.ConnectionPool(10,5,TimeUnit.MINUTES))
        .build()
}