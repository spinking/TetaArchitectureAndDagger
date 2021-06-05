package com.example.main.di

import com.example.common_utils.kotlin_coroutine_utils.DispatcherProvider
import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate
import com.example.common_utils.time_utils.TimeProvider
import com.example.network.impl.RetrofitProvider
import kotlin.reflect.KProperty

object MainComponentHolder : ComponentHolder<MainFeatureApi, MainFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
        MainFeatureApi,
        MainFeatureDependencies,
        MainComponent> { dependencies: MainFeatureDependencies ->
        MainComponent.initAndGet(dependencies)
    }

    internal fun getComponent(): MainComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> MainFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): MainFeatureApi = componentHolderDelegate.get()
}

// то что инициализируется в холдере
interface MainFeatureDependencies : BaseFeatureDependencies {
    val retrofitProvider: RetrofitProvider

}
//то что инициализируется в модуле или древе модулей
interface MainFeatureApi : BaseFeatureAPI {
    val dispatcherProvider: DispatcherProvider
    val timeProvider: TimeProvider
}
