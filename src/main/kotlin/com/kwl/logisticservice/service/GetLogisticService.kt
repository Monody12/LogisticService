package com.kwl.logisticservice.service

import com.kwl.logisticservice.util.OkHttpClientUtil
import okhttp3.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GetLogisticService {

    @Value("\${logistic.appCode}")
    private lateinit var appCode: String

    @Value("\${logistic.host}")
    private lateinit var host: String

    @Value("\${logistic.path}")
    private lateinit var path: String

    private val client: okhttp3.OkHttpClient = OkHttpClientUtil.client

    fun get(no: String, type: String?): String {
        val url = if (type == null) {
            "$host$path?no=$no"
        } else {
            "$host$path?no=$no&type=$type"
        }
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "APPCODE $appCode")
            .build()
        val response = client.newCall(request).execute()
        // 如果响应异常，直接抛出异常
        if (!response.isSuccessful) throw Exception("$response")
        return response.body!!.string()
    }
}