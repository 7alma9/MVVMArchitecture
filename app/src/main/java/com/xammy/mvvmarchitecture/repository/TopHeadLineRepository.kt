package com.xammy.mvvmarchitecture.repository

import androidx.lifecycle.LiveData
import com.xammy.mvvmarchitecture.api.Result
import com.xammy.mvvmarchitecture.data.news.NewsResponse
import kotlinx.coroutines.Job
/**
@author Salman Aziz
created on 2/22/21
 **/

interface TopHeadLineRepository {
      fun getTopHeadLinesBySource(sources: String,job:Job): LiveData<Result<NewsResponse>>
      fun getTopHeadLinesByCountry(country: String,job:Job): LiveData<Result<NewsResponse>>
 }