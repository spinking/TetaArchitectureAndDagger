package com.example.common_utils.di


import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate
import com.example.common_utils.time_utils.TimeProvider

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