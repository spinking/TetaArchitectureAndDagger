package com.example.myapp.common.config

import com.example.common_utils.config.ConfigProvider
import com.example.myapp.BuildConfig

class BuildConfigProviderImpl() : ConfigProvider {
    override val baseServer: String = BuildConfig.BASE_SERVER
}