package com.xammy.mvvmarchitecture

import android.app.Application
import com.xammy.mvvmarchitecture.di.networkModule
import com.xammy.mvvmarchitecture.di.repositoryModule
import com.xammy.mvvmarchitecture.di.sharedPrefModule
import com.xammy.mvvmarchitecture.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
/**
@author Salman Aziz
created on 2/22/21
 **/

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule+repositoryModule+viewModelModule+sharedPrefModule
            )
        }

    }
}