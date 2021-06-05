package com.example.myapp.app.dependency_holders.feature

import com.example.common_utils.di.CommonComponentHolder
import com.example.common_utils.di.CommonFeatureApi
import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder0
import com.example.common_utils.modul_injection.DependencyHolder2
import com.example.main.di.MainComponentHolder
import com.example.main.di.MainFeatureDependencies
import com.example.network.impl.RetrofitProvider
import com.example.network.di.NetworkComponentHolder
import com.example.network.di.NetworkFeatureApi

object MainHolderInjector {
    fun main_Injection() {
        MainComponentHolder.dependencyProvider = {
            class MainComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<MainFeatureDependencies>,
                    api1: CommonFeatureApi,
                    api2: NetworkFeatureApi
                ) -> MainFeatureDependencies
            ) : DependencyHolder2<CommonFeatureApi, NetworkFeatureApi, MainFeatureDependencies>(
                api1 = CommonComponentHolder.get(),
                api2 = NetworkComponentHolder.get()
            )

            MainComponentDependencyHolder { dependencyHolder, commonApi, netApi ->
                object : MainFeatureDependencies {
                    override val retrofitProvider: RetrofitProvider = netApi.retrofitProvider
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }

      /*  MainComponentHolder.dependencyProvider = {
            class MainComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<MainFeatureDependencies>
                ) -> MainFeatureDependencies
            ) : DependencyHolder0< MainFeatureDependencies>(
            )

            MainComponentDependencyHolder { dependencyHolder ->
                object : MainFeatureDependencies {
                    // override val retrofitProvider: RetrofitProvider = netApi.retrofitProvider
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }*/
    }
}