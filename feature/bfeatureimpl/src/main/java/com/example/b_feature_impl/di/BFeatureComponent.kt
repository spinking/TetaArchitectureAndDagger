package com.example.b_feature_impl.di

import com.example.b_feature_impl.viewmodel.BFeatureViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [BFeatureDependencies::class], modules = [BFeatureModule::class])
@Singleton
internal interface BFeatureComponent : BFeatureApi {

   fun inject(viewModel: BFeatureViewModel)

    companion object {
        fun initAndGet(commonDependencies: BFeatureDependencies): BFeatureComponent {
            return DaggerBFeatureComponent.builder()
                .bFeatureDependencies(commonDependencies)
                .build()
        }
    }
}
