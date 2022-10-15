package com.example.e_feature_impl.di

import com.example.e_feature_impl.viewmodel.EFeatureViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [EFeatureDependencies::class], modules = [EFeatureModule::class])
@Singleton
internal interface EFeatureComponent : EFeatureApi {

   fun inject(viewModel: EFeatureViewModel)

    companion object {
        fun initAndGet(eDependencies: EFeatureDependencies): EFeatureComponent {
            return DaggerEFeatureComponent.builder()
                .eFeatureDependencies(eDependencies)
                .build()
        }
    }
}
