package com.jetpack.avchmovie.fake

import com.jetpack.avchmovie.common.IConnectionDetector

class FakeConnectionDetector : IConnectionDetector {
    override fun isConnected(): Boolean {
        return true
    }
}
