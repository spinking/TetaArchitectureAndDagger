package com.example.common_utils.di


import com.example.common_utils.time_utils.TimeProvider
import com.example.common_utils.kotlin_coroutine_utils.DispatcherProvider
import com.example.common_utils.logs.Logger
import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate


object CommonComponentHolder : ComponentHolder<CommonFeatureApi, CommonFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            CommonFeatureApi,
            CommonFeatureDependencies,
            CommonComponent> { dependencies: CommonFeatureDependencies ->
        CommonComponent.initAndGet(dependencies)
    }

    internal fun getComponent(): CommonComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> CommonFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): CommonFeatureApi = componentHolderDelegate.get()
}

interface CommonFeatureDependencies : BaseFeatureDependencies {
    val logger: Logger
}

interface CommonFeatureApi : BaseFeatureAPI {
    val dispatcherProvider: DispatcherProvider
    val timeProvider: TimeProvider
}

