package com.example.common_impl.di

import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [CommonFeatureDependencies::class], modules = [CommonModule::class])
@Singleton
internal interface CommonComponent : CommonFeatureApi {

    companion object {
        fun initAndGet(commonDependencies: CommonFeatureDependencies): CommonComponent {
            return DaggerCommonComponent.builder()
                .commonFeatureDependencies(commonDependencies)
                .build()
        }
    }
}
