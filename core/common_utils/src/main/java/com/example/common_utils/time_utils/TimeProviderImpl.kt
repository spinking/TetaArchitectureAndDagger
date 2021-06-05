package com.example.common_utils.time_utils

import com.example.common_utils.time_utils.TimeProvider
import javax.inject.Inject

 class TimeProviderImpl @Inject constructor(
): TimeProvider {

    override val currentTimeInMillis: Long
        get() = System.currentTimeMillis()
}