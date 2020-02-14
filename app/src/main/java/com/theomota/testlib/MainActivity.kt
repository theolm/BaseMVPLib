package com.theomota.testlib

import android.os.Bundle
import com.theomota.basemvplib.RootActivity
import org.kodein.di.generic.instance

class MainActivity : RootActivity<MainView>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override val layoutResourceId: Int = R.layout.activity_main
    override val presenter: MainPresenter by instance()

    override fun initializeUI() {
        //TODO("not implemented")
    }

    override fun initializePresenter() {
        presenter.start(this)
    }

    override fun showError(messageId: Int) {
        //TODO("not implemented")
    }

    override fun showError(message: String) {
        //TODO("not implemented")
    }
}
