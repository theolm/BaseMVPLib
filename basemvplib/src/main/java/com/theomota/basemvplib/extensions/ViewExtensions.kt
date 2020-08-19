package com.theomota.basemvplib.extensions

import android.content.res.ColorStateList
import android.graphics.drawable.RippleDrawable
import android.transition.Fade
import android.transition.Transition
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.content.ContextCompat
import org.jetbrains.anko.dip


fun View.addRipple(color: Int) {
    val rippleDrawable = RippleDrawable(
        ColorStateList.valueOf(color),
        this.background,
        null
    )
    this.background = rippleDrawable
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.animateHide(duration: Long = 300, animation: Transition = Fade()) {
    val transition: Transition = animation
    transition.duration = duration
    transition.addTarget(this)

    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
    this.visibility = View.INVISIBLE

}

fun View.animateGone(duration: Long = 300, animation: Transition = Fade()) {
    val transition: Transition = animation
    transition.duration = duration
    transition.addTarget(this)

    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
    this.visibility = View.GONE

}

fun View.animateShow(duration: Long = 300, animation: Transition = Fade()) {
    val transition: Transition = animation
    transition.duration = duration
    transition.addTarget(this)

    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
    this.visibility = View.VISIBLE
}

fun View.setHeight(height: Int, toDip: Boolean) {
    val params = this.layoutParams
    params.height =
        if (toDip) {
            context.dip(height)
        } else {
            height
        }

    this.layoutParams = params
}

fun View.setWidth(width: Int, toDip: Boolean) {
    val params = this.layoutParams
    params.width =
        if (toDip) {
            context.dip(width)
        } else {
            width
        }

    this.layoutParams = params
}

fun View.setWidthWrap() {
    val params = this.layoutParams
    params.width = ViewGroup.LayoutParams.WRAP_CONTENT
    this.layoutParams = params
}

fun View.setHeightWrap() {
    val params = this.layoutParams
    params.height = ViewGroup.LayoutParams.WRAP_CONTENT
    this.layoutParams = params
}

fun View.setWidthMatch() {
    val params = this.layoutParams
    params.width = ViewGroup.LayoutParams.MATCH_PARENT
    this.layoutParams = params
}

fun View.setHeightMatch() {
    val params = this.layoutParams
    params.height = ViewGroup.LayoutParams.MATCH_PARENT
    this.layoutParams = params
}

fun View.getRippleDrawable(colorRes: Int, view: View): RippleDrawable {
    return RippleDrawable(
        ColorStateList.valueOf(ContextCompat.getColor(this.context, colorRes)),
        view.background,
        null
    )
}

fun View.executeAfterLayout(func: () -> Unit) {
    val view = this
    view.viewTreeObserver.addOnGlobalLayoutListener(object :
        ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            func.invoke()
            view.viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
    })
}