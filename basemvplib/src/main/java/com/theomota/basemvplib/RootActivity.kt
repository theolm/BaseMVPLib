package com.theomota.basemvplib

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

abstract class RootActivity<V : BaseView, VB : ViewBinding> : AppCompatActivity(), KodeinAware, BaseView {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB
    protected abstract val presenter: BasePresenter<V>
    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override val kodein by kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)

        initializePresenter()
        initializeUI()
    }

    protected abstract fun initializeUI()

    protected abstract fun initializePresenter()

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
        _binding = null
    }
}
