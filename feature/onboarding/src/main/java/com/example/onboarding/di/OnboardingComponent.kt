package com.example.onboarding.di

import com.example.onboarding.viewmodel.OnboardingViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [OnboardingFeatureDependencies::class], modules = [OnboardingModule::class])
@Singleton
internal interface OnboardingComponent : OnboardingFeatureApi {

   fun inject(viewModel: OnboardingViewModel)

    companion object {
        fun initAndGet(commonDependencies: OnboardingFeatureDependencies): OnboardingComponent {
            return DaggerOnboardingComponent.builder()
                .onboardingFeatureDependencies(commonDependencies)
                .build()
        }
    }
}
