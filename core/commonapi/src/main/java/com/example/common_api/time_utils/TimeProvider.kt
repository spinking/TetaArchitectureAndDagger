package com.example.common_api.time_utils

interface TimeProvider {

    /**
     * Returns current system time in milliseconds
     */
    val currentTimeInMillis: Long

}