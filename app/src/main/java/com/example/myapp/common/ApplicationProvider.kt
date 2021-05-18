package com.example.myapp.common

import android.content.Context


interface ApplicationProvider {

    /**
     * @returns application context
     */
    val applicationContext: Context
}