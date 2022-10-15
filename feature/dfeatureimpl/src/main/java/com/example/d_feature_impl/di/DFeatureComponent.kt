package com.example.d_feature_impl.di

import com.example.d_feature_impl.viewmodel.DFeatureViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [DFeatureDependencies::class], modules = [DFeatureModule::class])
@Singleton
internal interface DFeatureComponent : DFeatureApi {

   fun inject(viewModel: DFeatureViewModel)

    companion object {
        fun initAndGet(dDependencies: DFeatureDependencies): DFeatureComponent {
            return DaggerDFeatureComponent.builder()
                .dFeatureDependencies(dDependencies)
                .build()
        }
    }
}
