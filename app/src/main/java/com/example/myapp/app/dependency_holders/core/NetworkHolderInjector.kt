package com.example.myapp.app.dependency_holders.core

import com.example.common_api.config.ConfigProvider
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi
import com.example.network_impl.di.NetworkComponentHolder
import com.example.network_impl.di.NetworkFeatureDependencies

object NetworkHolderInjector {
    fun networkInjection(){
        NetworkComponentHolder.dependencyProvider = {
            class NetworkComponentDependencyHolder(
                override val block: (BaseDependencyHolder<NetworkFeatureDependencies>, api1: AppFeatureApi) -> NetworkFeatureDependencies
            ) : DependencyHolder1<AppFeatureApi, NetworkFeatureDependencies>(api1 = AppComponentHolder.get())

            NetworkComponentDependencyHolder { dependencyHolder, appApi ->
                object : NetworkFeatureDependencies {
                    override val configProvider: ConfigProvider = appApi.configProvider
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}