package com.jetpack.avchmovie.common

import android.content.Context
import android.net.ConnectivityManager

class ConnectionDetector(private val context: Context) {
    fun isConnected(): Boolean {
        val connectivityManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.isDefaultNetworkActive
    }
}
