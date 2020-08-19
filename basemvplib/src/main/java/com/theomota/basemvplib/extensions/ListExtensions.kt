package com.theomota.basemvplib.extensions

inline fun <reified T> List<T>.toArrayList() : ArrayList<T> = ArrayList(this)