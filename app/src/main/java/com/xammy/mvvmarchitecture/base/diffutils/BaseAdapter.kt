package com.xammy.mvvmarchitecture.base.diffutils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * @author Abdul Rahman
 */
abstract class BaseAdapter<B : ViewDataBinding, T, VH : BaseViewHolder<B>>
    (diffUtil: DiffUtil.ItemCallback<T>) : ListAdapter<T, BaseViewHolder<B>>(diffUtil) {

    abstract fun getLayoutId(): Int

    abstract fun getInflater(): LayoutInflater

    abstract fun createViewHolder(binding: B): BaseViewHolder<B>

    private fun inflateView(parent: ViewGroup): B {
        return DataBindingUtil.inflate(getInflater(), getLayoutId(), parent, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<B> {
        return createViewHolder(inflateView(parent))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<B>, position: Int) {
        holder.bind(position)
    }
}