package com.example.network_impl.di

import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [NetworkFeatureDependencies::class], modules = [NetworkModule::class])
@Singleton
internal interface
NetworkComponent : NetworkFeatureApi {

    companion object {
        fun initAndGet(networkDependencies: NetworkFeatureDependencies): NetworkComponent {
            return DaggerNetworkComponent.builder()
                .networkFeatureDependencies(networkDependencies)
                .build()
        }
    }
}
