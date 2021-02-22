package com.xammy.mvvmarchitecture.util

import android.content.SharedPreferences
/**
@author Salman Aziz
created on 2/22/21
 **/


class EncryptSharedPref(private val encryptedSharedPreferences: SharedPreferences) {


    fun saveString(key: String, value: String) {
        encryptedSharedPreferences.edit()
            .putString(key, value)
            .apply()
    }

    fun getString(key: String, defaultValue: String): String {
        return encryptedSharedPreferences.getString(key, defaultValue).toString()
    }

}