package com.xammy.mvvmarchitecture.repository.implementation

import androidx.lifecycle.MutableLiveData
import com.xammy.mvvmarchitecture.api.AllNewsApi
import com.xammy.mvvmarchitecture.api.Result
import com.xammy.mvvmarchitecture.base.BaseRepository
 import com.xammy.mvvmarchitecture.data.news.NewsResponse
import com.xammy.mvvmarchitecture.repository.AllNewsRepository
import kotlinx.coroutines.Job
/**
@author Salman Aziz
created on 2/22/21
 **/

@Suppress("UNCHECKED_CAST")
class AllNewsRepositoryImpl(private val allNewsApi: AllNewsApi) :
    AllNewsRepository {

    override fun getAllNews(
        query: Map<String, String>,
        job: Job
    ): MutableLiveData<Result<NewsResponse>> {
        return object : BaseRepository<NewsResponse, Map<String, String>>() {
            override suspend fun fetchFromNetwork(params: Map<String, String>): NewsResponse {
                return allNewsApi.getAllNews(params)
            }
         }.start(query, job) as MutableLiveData<Result<NewsResponse>>
    }


    override fun getDomainSpecificAllNews(
        sortBy: String,
        job: Job
    ): MutableLiveData<Result<NewsResponse>> {
        return object : BaseRepository<NewsResponse, String>() {
            override suspend fun fetchFromNetwork(params: String): NewsResponse {
                return allNewsApi.getDomainSpecificAllNews(params)
            }

         }.start(sortBy, job) as MutableLiveData<Result<NewsResponse>>
    }

}