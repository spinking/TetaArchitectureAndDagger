package com.example.profile.di

import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate
import com.example.common_utils.time_utils.TimeProvider

object ProfileComponentHolder : ComponentHolder<ProfileFeatureApi, ProfileFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
        ProfileFeatureApi,
        ProfileFeatureDependencies,
        ProfileComponent> { dependencies: ProfileFeatureDependencies ->
        ProfileComponent.initAndGet(dependencies)
    }

    //internal fun getComponent(): ProfileComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> ProfileFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): ProfileFeatureApi = componentHolderDelegate.getComponentImpl()
}

// то что инициализируется в холдере
interface ProfileFeatureDependencies : BaseFeatureDependencies {
}

//то что инициализируется в модуле или древе модулей
interface ProfileFeatureApi : BaseFeatureAPI {
}