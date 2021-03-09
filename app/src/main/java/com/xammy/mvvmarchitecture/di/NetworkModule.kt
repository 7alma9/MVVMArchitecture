package com.xammy.mvvmarchitecture.di

import com.xammy.mvvmarchitecture.BuildConfig
import com.xammy.mvvmarchitecture.api.AllNewsApi
import com.xammy.mvvmarchitecture.constants.connectionTimeOut
import com.xammy.mvvmarchitecture.constants.readTimeOut
import com.xammy.mvvmarchitecture.util.NetworkInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
@author Salman Aziz
created on 2/22/21
 **/

val networkModule = module {
    single { createOkHttpClient() }
    single { createRetrofit(get(), BuildConfig.BASE_URL) }
    single { createAllNewsApi(get()) }
 }

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }
    return OkHttpClient.Builder()
        .connectTimeout(connectionTimeOut, TimeUnit.SECONDS)
        .readTimeout(readTimeOut, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(NetworkInterceptor())

        .build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun createAllNewsApi(retrofit: Retrofit): AllNewsApi = retrofit.create(AllNewsApi::class.java)
