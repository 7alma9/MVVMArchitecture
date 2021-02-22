package com.xammy.mvvmarchitecture.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.xammy.mvvmarchitecture.api.AllNewsApi
import com.xammy.mvvmarchitecture.constants.KEY_PREF_NAME
import com.xammy.mvvmarchitecture.repository.AllNewsRepository
import com.xammy.mvvmarchitecture.repository.implementation.AllNewsRepositoryImpl
import com.xammy.mvvmarchitecture.ui.newslisting.NewsViewModel
import com.xammy.mvvmarchitecture.util.EncryptSharedPref
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
/**
@author Salman Aziz
created on 2/22/21
 **/

val repositoryModule = module {
    single { createAllNewsRepository(get()) }

}

val viewModelModule = module {
    viewModel {
        NewsViewModel(
            get(),
            get()
        )
    }
}

val sharedPrefModule = module {
    single { createMasterKey(androidContext()) }
    single { creteEncryptedSharedPref(androidContext(), get()) }
    single { EncryptSharedPref(get()) }
}


fun createAllNewsRepository(allNewsApi: AllNewsApi): AllNewsRepository {
    return AllNewsRepositoryImpl(
        allNewsApi
    )
}


fun createMasterKey(context: Context): MasterKey {
    return MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build();
}

private fun creteEncryptedSharedPref(
    context: Context,
    masterKeyAlias: MasterKey
): SharedPreferences {

    return EncryptedSharedPreferences.create(
        context,
        KEY_PREF_NAME,
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}

