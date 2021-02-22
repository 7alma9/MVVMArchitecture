package com.xammy.mvvmarchitecture.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.xammy.mvvmarchitecture.api.Result
import kotlinx.coroutines.Job

/**
@author Salman Aziz
created on 2/22/21
 **/

abstract class BaseViewModel : ViewModel() {
  companion  object {
      var job = Job()
  }
    var outcomeLiveData = MediatorLiveData<Result<*>>()

    // Cancel the job when the view model is destroyed
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}