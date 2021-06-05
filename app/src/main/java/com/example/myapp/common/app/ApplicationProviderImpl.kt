package com.example.myapp.common.app

import android.content.Context
import com.example.myapp.common.app.ApplicationProvider

class ApplicationProviderImpl(appContext: Context) :
    ApplicationProvider {
    override val applicationContext: Context = appContext
}