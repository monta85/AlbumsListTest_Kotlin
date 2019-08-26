package com.android.albumslist.application

import android.app.Application

class AlbumsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InitializeDebug().init(this)
    }
}