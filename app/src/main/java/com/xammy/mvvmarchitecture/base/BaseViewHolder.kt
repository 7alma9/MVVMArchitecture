package com.xammy.mvvmarchitecture.base

import android.content.Context
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
@author Salman Aziz
created on 2/22/21
 **/

@Suppress("unused", "LeakingThis")
abstract class BaseViewHolder<V:ViewDataBinding>(private val view: V) :
    RecyclerView.ViewHolder(view.root),View.OnClickListener,View.OnLongClickListener {
   init {
       view.root.setOnClickListener(this)
       view.root.setOnLongClickListener(this)
   }
    abstract fun bindData(data:Any,postion:Int)
    fun view()=view.root
    fun binding()=view
    fun context(): Context =view.root.context

}