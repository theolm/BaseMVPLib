package com.theomota.basemvplib.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.fromJavascriptDate(jsDate: String) : Date {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
    return formatter.parse(jsDate)!!
}

fun Date.toFormat(pattern: String) : String = SimpleDateFormat(pattern).format(this)