package com.example.droidstagram

import android.app.Application
import com.facebook.soloader.SoLoader

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        // Soloader engine
        SoLoader.init(this, false)
    }
}