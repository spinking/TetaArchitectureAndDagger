package com.example.common_utils.time_utils

interface TimeProvider {

    /**
     * Returns current system time in milliseconds
     */
    val currentTimeInMillis: Long

}