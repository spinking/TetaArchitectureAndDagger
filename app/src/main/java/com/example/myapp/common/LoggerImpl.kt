package com.example.myapp.common

import android.util.Log
import com.example.common_utils.logs.Logger
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {
    override fun e(tag: String, message: String) {
        Log.v(tag, message)
    }
}