package com.example.profile.di

import com.example.profile.viewmodel.ProfileViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [ProfileFeatureDependencies::class], modules = [ProfileModule::class])
@Singleton
internal interface ProfileComponent : ProfileFeatureApi {

   fun inject(viewModel: ProfileViewModel)

    companion object {
        fun initAndGet(profileDependencies: ProfileFeatureDependencies): ProfileComponent {
            return DaggerProfileComponent.builder()
                .profileFeatureDependencies(profileDependencies)
                .build()
        }
    }
}
