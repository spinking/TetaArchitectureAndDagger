package com.example.myapp.app

import android.app.Application
import com.example.myapp.common.LoggerHandler

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LoggerHandler.initTimber()
        DependencyHandler.initDependency(applicationContext)
    }
}