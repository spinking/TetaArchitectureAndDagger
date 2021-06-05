package com.example.onboarding.di

import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate
import com.example.common_utils.time_utils.TimeProvider

object OnboardingComponentHolder : ComponentHolder<OnboardingFeatureApi, OnboardingFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
        OnboardingFeatureApi,
        OnboardingFeatureDependencies,
        OnboardingComponent> { dependencies: OnboardingFeatureDependencies ->
        OnboardingComponent.initAndGet(dependencies)
    }

    //internal fun getComponent(): OnboardingComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> OnboardingFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): OnboardingFeatureApi = componentHolderDelegate.getComponentImpl()
}
// то что инициализируется в холдере
interface OnboardingFeatureDependencies : BaseFeatureDependencies {
}
//то что инициализируется в модуле или древе модулей
interface OnboardingFeatureApi : BaseFeatureAPI {

}
