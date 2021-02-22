package com.xammy.mvvmarchitecture.ui.newsdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.transition.ChangeBounds
import androidx.transition.TransitionInflater
import com.xammy.mvvmarchitecture.R
import com.xammy.mvvmarchitecture.base.BaseFragment
import com.xammy.mvvmarchitecture.data.ErrorDescription
import com.xammy.mvvmarchitecture.databinding.FragmentNewsDetailsBinding

/**
@author Salman Aziz
created on 2/22/21
 **/


class NewsDetailsFragment : BaseFragment<FragmentNewsDetailsBinding>() {

      val news by lazy {
          NewsDetailsFragmentArgs.fromBundle(requireArguments()).news
      }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.data=news
        Log.d("news.title","${news.title}")
    }

    override fun getLayoutId()=R.layout.fragment_news_details



    override fun getViewModel()=null


    override fun initFragment() {
         binding.lifecycleOwner=this
    }


}