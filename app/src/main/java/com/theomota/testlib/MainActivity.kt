package com.theomota.testlib

import android.view.LayoutInflater
import com.theomota.basemvplib.RootActivity
import com.theomota.testlib.databinding.ActivityMainBinding
import org.kodein.di.generic.instance

class MainActivity : RootActivity<MainView, ActivityMainBinding>(), MainView {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
    override val presenter: MainPresenter by instance()

    override fun initializeUI() {
        binding.mainText.text = "lol"
    }

    override fun initializePresenter() {
        presenter.start(this)
    }

}
