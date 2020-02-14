package com.theomota.basemvplib

interface BaseListView {
    fun showLoader()
    fun hideLoader()
    fun showEmptyMessage()
    fun hideEmptyMessage()
}