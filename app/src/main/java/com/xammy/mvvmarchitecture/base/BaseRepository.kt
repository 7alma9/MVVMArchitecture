package com.xammy.mvvmarchitecture.base

import androidx.lifecycle.*
import com.xammy.mvvmarchitecture.api.Result
import com.xammy.mvvmarchitecture.data.ErrorDescription
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
/**
@author Salman Aziz
created on 2/22/21
 **/

abstract class BaseRepository<Response, Params> internal constructor() {

    abstract suspend fun fetchFromNetwork(params: Params): Response


    open fun start(
        params: Params,
        job: Job

    ): LiveData<Result<out Any?>> = liveData(Dispatchers.IO + job) {
        emit(Result.Loading(true))
        try {
            emit(Result.Success(fetchFromNetwork(params)))
        } catch (e: HttpException) {
            emit(Result.NetworkError<Error>(ErrorDescription(e.localizedMessage!!)))

        } catch (e: UnknownHostException) {
            emit(Result.NetworkError<Error>(ErrorDescription(e.localizedMessage!!)))
        } catch (e: SocketTimeoutException) {
            emit(Result.NetworkError<Error>(ErrorDescription(e.localizedMessage!!)))
        } catch (ex: Exception) {
            emit(Result.Failure<Error>(ErrorDescription(ex.localizedMessage!!)))
        }
    }
}