package com.theomota.basemvplib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein


abstract class RootDialogFragment<V : BaseView, VB : ViewBinding> : DialogFragment(), KodeinAware, BaseView {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    @Suppress("UNCHECKED_CAST")
    protected val binding: VB?
        get() = _binding as VB?
    protected abstract val presenter: BasePresenter<V>
    override val kodein by kodein()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        initializePresenter()
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
        presenter.destroy()
        _binding = null
        super.onDestroyView()
    }

    fun setFullWidth(){
        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        params?.width = LinearLayout.LayoutParams.MATCH_PARENT
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    fun setFullHeight(){
        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        params?.height = LinearLayout.LayoutParams.MATCH_PARENT
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    override fun isBindingNotNull(): Boolean = _binding != null

}