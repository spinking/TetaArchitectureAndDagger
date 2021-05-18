package com.example.common_utils.di


import com.example.common_utils.logs.Logger
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [CommonFeatureDependencies::class], modules = [CommonModule::class])
@Singleton
internal interface CommonComponent : CommonFeatureApi {

    val logger: Logger

    companion object {
        fun initAndGet(commonDependencies: CommonFeatureDependencies): CommonComponent {
            return DaggerCommonComponent.builder()
                .commonFeatureDependencies(commonDependencies)
                .build()
        }
    }
}
