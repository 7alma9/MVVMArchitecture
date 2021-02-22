package com.xammy.mvvmarchitecture.api

import com.xammy.mvvmarchitecture.data.news.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
/**
@author Salman Aziz
created on 2/22/21
 **/

interface AllNewsApi {
    @GET("/v2/everything")
    suspend fun getAllNews(
    @QueryMap options :Map<String, String>
    ):NewsResponse

    @GET("/v2/everything")
    suspend fun getDomainSpecificAllNews(
        @Query("sortBy") sortBy: String = "domains=wsj.com"
    ):NewsResponse

}
// http://newsapi.org/v2/everything?q=tesla&from=2021-01-03&sortBy=publishedAt&apiKey=API_KEY
//http://newsapi.org/v2/everything?domains=wsj.com&apiKey=API_KEY