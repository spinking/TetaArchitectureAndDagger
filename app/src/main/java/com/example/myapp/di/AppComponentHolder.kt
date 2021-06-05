package com.example.myapp.di

import com.example.common_utils.config.ConfigProvider
import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate
import com.example.common_utils.time_utils.TimeProvider
import com.example.myapp.common.app.ApplicationProvider

object AppComponentHolder : ComponentHolder<AppFeatureApi, AppFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
        AppFeatureApi,
        AppFeatureDependencies,
        AppComponent> {
        AppComponent.initAndGet(it)
    }

    // internal fun getComponent(): AppComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> AppFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): AppFeatureApi = componentHolderDelegate.getComponentImpl()
}

// то что инициализируется в холдере
interface AppFeatureDependencies : BaseFeatureDependencies {
    val appProvider: ApplicationProvider
    val configProvider: ConfigProvider
}

//то что инициализируется в модуле или древе модулей
interface AppFeatureApi : BaseFeatureAPI {
    val timeProvider: TimeProvider
    val configProvider: ConfigProvider


}