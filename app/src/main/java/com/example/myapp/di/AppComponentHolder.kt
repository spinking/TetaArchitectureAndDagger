package com.example.myapp.di

import com.example.common_utils.logs.Logger
import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate
import com.example.myapp.common.ApplicationProvider

object AppComponentHolder : ComponentHolder<AppFeature, AppFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            AppFeature,
            AppFeatureDependencies,
            AppComponent> {
        AppComponent.initAndGet(it)
    }

    internal fun getComponent(): AppComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> AppFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): AppFeature {
        return getComponent()
    }
}

interface AppFeature : BaseFeatureAPI {
    val logger: Logger
    //val generalSettingsRepositoryImpl: GeneralSettingsRepositoryImpl
    //val weatherOnlineRepositoryImpl: WeatherOnlineRepositoryImpl
    //val weatherOfflineRepositoryImpl: WeatherOfflineRepositoryImpl
}

interface AppFeatureDependencies : BaseFeatureDependencies {
    val appProvider: ApplicationProvider
}