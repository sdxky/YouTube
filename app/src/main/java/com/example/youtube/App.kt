package com.example.youtube

import android.app.Application
import com.example.youtube.di.youtubeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(youtubeModule)
        }
    }
}