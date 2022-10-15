package com.example.d_feature_impl.di

import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate


object DFeatureComponentHolder : ComponentHolder<DFeatureApi, DFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            DFeatureApi,
            DFeatureDependencies,
            DFeatureComponent> { dependencies: DFeatureDependencies ->
        DFeatureComponent.initAndGet(dependencies)
    }


    override var dependencyProvider: (() -> DFeatureDependencies)? by
    componentHolderDelegate::dependencyProvider

    override fun get(): DFeatureApi = componentHolderDelegate.getComponentImpl()
}

// то что инициализируется в холдере
interface DFeatureDependencies : BaseFeatureDependencies {
}

//то что инициализируется в модуле или древе модулей
interface DFeatureApi : BaseFeatureAPI {
}