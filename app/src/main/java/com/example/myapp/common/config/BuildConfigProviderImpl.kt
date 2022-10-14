package com.example.myapp.common.config

import com.example.common_api.config.ConfigProvider
import com.example.myapp.BuildConfig

class BuildConfigProviderImpl() : ConfigProvider {
    override val baseServer: String = BuildConfig.BASE_SERVER
}