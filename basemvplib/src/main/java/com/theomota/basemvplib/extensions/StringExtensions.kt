package com.theomota.basemvplib.extensions

import android.text.SpannableString

fun SpannableString.spanWith(target: String?, apply: SpannableBuilder.() -> Unit) {
    target?.let {
        val builder = SpannableBuilder()
        apply(builder)

        val start = this.indexOf(target)
        val end =  start + target.length

        setSpan(builder.what, start, end, builder.flags)
    }
}

class SpannableBuilder {
    lateinit var what: Any
    var flags: Int = 0
}