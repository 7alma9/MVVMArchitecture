package com.xammy.mvvmarchitecture.base.diffutils

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Abdul Rahman
 */
abstract class BaseViewHolder<B : ViewDataBinding>(binding: B) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(position: Int)
}