package com.example.myapp.app.dependency_holders.feature

import com.example.a_feature_impl.di.AFeatureComponentHolder
import com.example.common_impl.di.CommonComponentHolder
import com.example.common_impl.di.CommonFeatureApi
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder2
import com.example.a_feature_impl.di.AFeatureDependencies
import com.example.network_api.RetrofitProvider
import com.example.network_impl.di.NetworkComponentHolder
import com.example.network_impl.di.NetworkFeatureApi

object AFeatureHolderInjector {
    fun aFeatureInjection() {
        AFeatureComponentHolder.dependencyProvider = {
            class MainComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<AFeatureDependencies>,
                    api1: CommonFeatureApi,
                    api2: NetworkFeatureApi
                ) -> AFeatureDependencies
            ) : DependencyHolder2<CommonFeatureApi, NetworkFeatureApi, AFeatureDependencies>(
                api1 = CommonComponentHolder.get(),
                api2 = NetworkComponentHolder.get()
            )

            MainComponentDependencyHolder { dependencyHolder, commonApi, netApi ->
                object : AFeatureDependencies {
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