package com.example.myapp.app.dependency_holders.feature

import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi
import com.example.onboarding.di.OnboardingComponentHolder
import com.example.onboarding.di.OnboardingFeatureDependencies

object OnboardingHolderInjector {
    fun onboarding_Injection(){
        OnboardingComponentHolder.dependencyProvider = {
            class OnboardingComponentDependencyHolder(
                override val block: (BaseDependencyHolder<OnboardingFeatureDependencies>, api1: AppFeatureApi) -> OnboardingFeatureDependencies
            ) : DependencyHolder1<AppFeatureApi, OnboardingFeatureDependencies>(api1 = AppComponentHolder.get())

            OnboardingComponentDependencyHolder { dependencyHolder, appApi ->
                object : OnboardingFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}