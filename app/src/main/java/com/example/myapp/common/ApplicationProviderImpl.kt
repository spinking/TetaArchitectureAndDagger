package com.example.myapp.common

import android.content.Context
import com.example.myapp.app.App

class ApplicationProviderImpl(appContext: Context) : ApplicationProvider {

    override val applicationContext: Context = appContext
}