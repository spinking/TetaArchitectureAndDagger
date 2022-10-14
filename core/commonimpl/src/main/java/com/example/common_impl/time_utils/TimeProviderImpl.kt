package com.example.common_impl.time_utils

import com.example.common_api.time_utils.TimeProvider
import javax.inject.Inject

 class TimeProviderImpl @Inject constructor(
): TimeProvider {

    override val currentTimeInMillis: Long
        get() = System.currentTimeMillis()
}