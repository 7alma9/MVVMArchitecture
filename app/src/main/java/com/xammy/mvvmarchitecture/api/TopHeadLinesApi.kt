package com.xammy.mvvmarchitecture.api

import com.xammy.mvvmarchitecture.data.news.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query
/**
@author Salman Aziz
created on 2/22/21
 **/

interface TopHeadLinesApi {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadLinesBySource(@Query("sources") sources: String) :NewsResponse
    @GET("/v2/top-headlines")
    suspend fun getTopHeadLinesByCountry(@Query("country") country: String):NewsResponse
}
//http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY
//http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=API_KEY