package com.example.c_feature_impl.di

import com.example.c_feature_impl.viewmodel.CFeatureViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [CFeatureDependencies::class], modules = [CFeatureModule::class])
@Singleton
internal interface CFeatureComponent : CFeatureApi {

   fun inject(viewModel: CFeatureViewModel)

    companion object {
        fun initAndGet(cDependencies: CFeatureDependencies): CFeatureComponent {
            return DaggerCFeatureComponent.builder()
                .cFeatureDependencies(cDependencies)
                .build()
        }
    }
}
