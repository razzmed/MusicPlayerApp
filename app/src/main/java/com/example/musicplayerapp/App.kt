package com.example.musicplayerapp

import android.app.Application
import com.example.musicplayerapp.di.playerModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            this@App
            modules(playerModule)
        }
    }
}