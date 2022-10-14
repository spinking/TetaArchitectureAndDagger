package com.example.a_feature_impl.di

import com.example.a_feature_impl.viewmodel.AFeatureViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [AFeatureDependencies::class], modules = [AFeatureModule1::class, AFeatureModule2::class])
@Singleton
internal interface AFeatureComponent : AFeatureApi {

   fun inject(viewModel: AFeatureViewModel)

    companion object {
        fun initAndGet(aFeatureDependencies: AFeatureDependencies): AFeatureComponent {
            return DaggerAFeatureComponent.builder()
                .aFeatureDependencies(aFeatureDependencies)
                .build()
        }
    }
}
