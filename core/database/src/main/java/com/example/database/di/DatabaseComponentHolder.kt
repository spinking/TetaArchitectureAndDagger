package com.example.database.di

import com.example.common_utils.modul_injection.BaseFeatureAPI
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.ComponentHolder
import com.example.common_utils.modul_injection.ComponentHolderDelegate
import com.example.common_utils.time_utils.TimeProvider

object DatabaseComponentHolder : ComponentHolder<DatabaseFeatureApi, DatabaseFeatureDependencies> {
    private val
        componentHolderDelegate = ComponentHolderDelegate<
        DatabaseFeatureApi,
        DatabaseFeatureDependencies,
        DatabaseComponent> { dependencies: DatabaseFeatureDependencies ->
        DatabaseComponent.initAndGet(dependencies)
    }

    //internal fun getComponent(): DatabaseComponent = componentHolderDelegate.getComponentImpl()

    override var dependencyProvider: (() -> DatabaseFeatureDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): DatabaseFeatureApi = componentHolderDelegate.getComponentImpl()
}
// то что инициализируется в холдере
interface DatabaseFeatureDependencies : BaseFeatureDependencies {
    //val logger: Logger
}
//то что инициализируется в модуле или древе модулей
interface DatabaseFeatureApi : BaseFeatureAPI {
    //val dispatcherProvider: DispatcherProvider
    //val timeProvider: TimeProvider
}
