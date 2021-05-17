package com.example.myapp.app

import android.app.Application
import com.example.common_utils.modul_injection.DependencyHandler

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DependencyHandler.initDependency()

        // досоздать даггер
            // настроить навигатор гугл
            // настроить вьюмодели
            // настроить корутины
            // настроить lce патерн и ретрофит
            // настроить livedata patern
        // настроить сервис пушей с диплинками
            //
    }
}