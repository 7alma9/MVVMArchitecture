package com.xammy.mvvmarchitecture.ui.newslisting

import com.xammy.mvvmarchitecture.R
import com.xammy.mvvmarchitecture.base.BaseAdapter
import com.xammy.mvvmarchitecture.base.BaseViewHolder
import com.xammy.mvvmarchitecture.data.news.News
import com.xammy.mvvmarchitecture.databinding.ItemNewsBinding
/**
@author Salman Aziz
created on 2/22/21
 **/

class NewsAdapter(
    private val clickListener: (result: News) -> Unit
) : BaseAdapter<ItemNewsBinding>() {
    init {
        addData(ArrayList<News>())
    }
    fun addNewsList(data: List<News>) {
        data.let {
            addData(it)
            notifyDataSetChanged()
        }
    }

    override fun viewHolder(layout: Int, binding: ItemNewsBinding): BaseViewHolder<ItemNewsBinding> {
        return NewsViewHolder(binding,clickListener)
    }

    override fun layout(position: Int): Int {
        return R.layout.item_news
    }

}