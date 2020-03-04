package com.theomota.basemvplib.extensions

import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.theomota.basemvplib.custom.DividerItemDecorator


fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val drawable = ContextCompat.getDrawable(
        this.context,
        drawableRes
    )
    drawable?.let {
        val divider = DividerItemDecorator(ContextCompat.getDrawable(context, drawableRes))
        addItemDecoration(divider)
    }
}