package com.xammy.mvvmarchitecture.ui.newslisting

 import android.view.View
import com.xammy.mvvmarchitecture.base.BaseViewHolder
import com.xammy.mvvmarchitecture.data.news.News
import com.xammy.mvvmarchitecture.databinding.ItemNewsBinding
/**
@author Salman Aziz
created on 2/22/21
 **/

class NewsViewHolder(
    view: ItemNewsBinding,
    val clickListener: (result: News) -> Unit
) : BaseViewHolder<ItemNewsBinding>(view) {

    private lateinit var news: News

    override fun bindData(data: Any,position: Int) {

        if (data is News) {
            news = data
             binding().data = news
        }
    }

    override fun onClick(v: View?) {
        clickListener(news)
    }

    override fun onLongClick(v: View?): Boolean {
        return false
    }
}