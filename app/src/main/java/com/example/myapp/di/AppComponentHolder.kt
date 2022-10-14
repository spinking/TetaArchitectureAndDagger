package com.example.myapp.di

import com.example.common_api.config.ConfigProvider
import com.example.common_api.time_utils.TimeProvider
import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate
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