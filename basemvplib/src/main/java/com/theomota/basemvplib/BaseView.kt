package com.theomota.basemvplib

interface BaseView {
    fun showError(messageId: Int)
    fun showError(message: String)
}