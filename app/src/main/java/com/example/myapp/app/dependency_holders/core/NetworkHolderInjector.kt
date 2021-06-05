package com.example.myapp.app.dependency_holders.core

import com.example.common_utils.config.ConfigProvider
import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi
import com.example.network.di.NetworkComponentHolder
import com.example.network.di.NetworkFeatureDependencies

object NetworkHolderInjector {
    fun network_Injection(){
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