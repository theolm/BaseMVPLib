package com.theomota.basemvplib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.jetbrains.anko.design.snackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein


abstract class RootFragment<V : BaseView, VB : ViewBinding> : Fragment(), KodeinAware, BaseView {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    @Suppress("UNCHECKED_CAST")
    protected val binding: VB?
        get() = _binding as VB?
    protected abstract val presenter: BasePresenter<V>
    override val kodein by kodein()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        presenter.destroy()
    }

    override fun showError(message: String) {
        binding?.root?.snackbar(message)
    }

    override fun showError(messageId: Int) {
        binding?.root?.snackbar(messageId)
    }

    override fun isBindingNotNull(): Boolean = _binding != null
}
