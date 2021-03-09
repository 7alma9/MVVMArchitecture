package com.xammy.mvvmarchitecture.ui.newslisting

import com.xammy.mvvmarchitecture.R
import com.xammy.mvvmarchitecture.base.BaseActivity
import com.xammy.mvvmarchitecture.base.BaseViewModel
import com.xammy.mvvmarchitecture.databinding.ActivityMainBinding

/**
@author Salman Aziz
created on 2/22/21
 **/

class NewsListingActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewModel(): BaseViewModel? {
         return null
    }

    override fun hasConnectivity(connectivity: Boolean) {
        if (!connectivity)
            noConnectivity()
    }


    override fun getLayoutId() = R.layout.activity_main

    override fun getNavHostId(): Int {
      return R.id.nav_host_fragment
    }
}