package com.example.myapp.common.app

import android.content.Context


interface ApplicationProvider {

    /**
     * @returns application context
     */
    val applicationContext: Context
}