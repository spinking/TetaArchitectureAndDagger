package com.example.common_impl.di

import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate


object CommonComponentHolder : ComponentHolder<CommonFeatureApi, CommonFeatureDependencies> {
    private val
        componentHolderDelegate = ComponentHolderDelegate<
            CommonFeatureApi,
            CommonFeatureDependencies,
            CommonComponent> { dependencies: CommonFeatureDependencies ->
        CommonComponent.initAndGet(dependencies)
    }

    //internal fun getComponent(): CommonComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> CommonFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): CommonFeatureApi = componentHolderDelegate.getComponentImpl()
}
// то что инициализируется в холдере
interface CommonFeatureDependencies : BaseFeatureDependencies {
    //val logger: Logger
}
//то что инициализируется в модуле или древе модулей
interface CommonFeatureApi : BaseFeatureAPI {
    //val dispatcherProvider: DispatcherProvider
    //val timeProvider: TimeProvider
}