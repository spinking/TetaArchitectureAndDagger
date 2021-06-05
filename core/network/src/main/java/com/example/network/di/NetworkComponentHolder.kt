package com.example.network.di

import com.example.common_utils.config.ConfigProvider
import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate
import com.example.network.impl.RetrofitProvider

object NetworkComponentHolder : ComponentHolder<NetworkFeatureApi, NetworkFeatureDependencies> {
    private val
        componentHolderDelegate = ComponentHolderDelegate<
        NetworkFeatureApi,
        NetworkFeatureDependencies,
        NetworkComponent> { dependencies: NetworkFeatureDependencies ->
        NetworkComponent.initAndGet(dependencies)
    }

    //internal fun getComponent(): NetworkComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> NetworkFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): NetworkFeatureApi = componentHolderDelegate.getComponentImpl()
}

// то что инициализируется в холдере
interface NetworkFeatureDependencies : BaseFeatureDependencies {
    val configProvider: ConfigProvider
}

//то что инициализируется в модуле или древе модулей
interface NetworkFeatureApi : BaseFeatureAPI {
    val retrofitProvider: RetrofitProvider
}
