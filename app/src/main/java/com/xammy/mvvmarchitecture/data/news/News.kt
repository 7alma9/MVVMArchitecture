package com.xammy.mvvmarchitecture.data.news

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/**
@author Salman Aziz
created on 2/22/21
 **/

@Parcelize
data class News(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
):Parcelable
@Parcelize
data class Source(val id: String, val name: String):Parcelable