package com.xammy.mvvmarchitecture.ui.newslisting

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.xammy.mvvmarchitecture.api.Result
import com.xammy.mvvmarchitecture.base.BaseViewModel
import com.xammy.mvvmarchitecture.constants.pageSize
import com.xammy.mvvmarchitecture.data.news.NewsResponse
import com.xammy.mvvmarchitecture.repository.AllNewsRepository
import com.xammy.mvvmarchitecture.util.EncryptSharedPref
/**
@author Salman Aziz
created on 2/22/21
 **/

class NewsViewModel(
    private val allNewsRepository: AllNewsRepository,
    private val sharedPreferences: EncryptSharedPref

) :
    BaseViewModel() {


    private lateinit var _allNewsLiveData: MutableLiveData<Result<NewsResponse>>

    private var allNewsResultLiveData: MediatorLiveData<Result<NewsResponse>> = MediatorLiveData()


    fun getAllNews() = allNewsResultLiveData

    fun fetchAllNews(page: Int) {
         val data: MutableMap<String, String> = HashMap()
        data["page"] = page.toString()
        data["q"] = "a"
        data["sortBy"] = "published"
        data["pageSize"] = pageSize.toString()

        if (this::_allNewsLiveData.isInitialized)
            allNewsResultLiveData.removeSource(_allNewsLiveData)

        _allNewsLiveData =
            allNewsRepository .getAllNews(data, job)
        allNewsResultLiveData.addSource(_allNewsLiveData) { outcome ->
            outcomeLiveData.value = outcome
            outcome.let {
                allNewsResultLiveData.value = it
            }
            when (outcome) {
                is com.xammy.mvvmarchitecture.api.Result.Success -> {

                    outcome.let {
                        allNewsResultLiveData.value = it
                    }
                }
                else -> {

                }
            }
        }


    }


}