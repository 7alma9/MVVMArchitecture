package com.xammy.mvvmarchitecture.util

import com.xammy.mvvmarchitecture.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
@author Salman Aziz
created on 2/22/21
 **/

class NetworkInterceptor : Interceptor {
     override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("apiKey", BuildConfig.API_KEY)
            .build()
        val request: Request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}