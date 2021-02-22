package com.xammy.mvvmarchitecture.bindings

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
/**
@author Salman Aziz
created on 2/22/21
 **/

@BindingAdapter("loadImage")
fun loadImageWithGlide(view: AppCompatImageView,url:String) {
     Glide.with(view.context)
                .load(url)
                .into(view)
}