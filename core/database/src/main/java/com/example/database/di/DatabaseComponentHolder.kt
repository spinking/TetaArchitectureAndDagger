package com.example.database.di

import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate


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
