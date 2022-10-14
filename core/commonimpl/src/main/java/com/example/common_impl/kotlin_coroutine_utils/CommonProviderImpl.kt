package com.example.common_impl.kotlin_coroutine_utils

import com.example.common_api.kotlin_coroutine_utils.CommonProviderApi
import javax.inject.Inject

internal class CommonProviderImpl @Inject constructor() : CommonProviderApi {

    override fun getData1(): String = "Light"

    override fun getData2(): String = "Dark"
}