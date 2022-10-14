package com.example.network_impl.di

import com.example.common_api.config.ConfigProvider
import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate
import com.example.network_api.RetrofitProvider

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
