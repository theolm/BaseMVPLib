package com.theomota.basemvplib.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> CoroutineScope.runIO(block: suspend CoroutineScope.() -> T): T = withContext(
    Dispatchers.IO, block
)

suspend fun <T> CoroutineScope.runMain(block: suspend CoroutineScope.() -> T): T = withContext(
    Dispatchers.Main, block
)

suspend fun <T> CoroutineScope.runDefault(block: suspend CoroutineScope.() -> T): T = withContext(
    Dispatchers.Default, block
)