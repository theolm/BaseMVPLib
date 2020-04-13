package com.theomota.testlib

import android.util.Log
import com.theomota.basemvplib.BasePresenter

class MainPresenter : BasePresenter<MainView>() {

    override fun initialize() {
        Log.d("MVPLIB", "initialize presenter")
    }

    override fun resume() {
        Log.d("MVPLIB", "resume presenter")
    }

    override fun pause() {
        Log.d("MVPLIB", "pause presenter")
    }

    override fun stop() {
        Log.d("MVPLIB", "stop presenter")
    }

    override fun destroy() {
        Log.d("MVPLIB", "destroy presenter")
    }
}