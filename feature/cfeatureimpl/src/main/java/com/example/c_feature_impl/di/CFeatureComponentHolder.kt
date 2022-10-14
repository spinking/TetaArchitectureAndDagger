package com.example.c_feature_impl.di

import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate


object CFeatureComponentHolder : ComponentHolder<CFeatureApi, CFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            CFeatureApi,
            CFeatureDependencies,
            CFeatureComponent> { dependencies: CFeatureDependencies ->
        CFeatureComponent.initAndGet(dependencies)
    }


    override var dependencyProvider: (() -> CFeatureDependencies)? by
    componentHolderDelegate::dependencyProvider

    override fun get(): CFeatureApi = componentHolderDelegate.getComponentImpl()
}

// то что инициализируется в холдере
interface CFeatureDependencies : BaseFeatureDependencies {
}

//то что инициализируется в модуле или древе модулей
interface CFeatureApi : BaseFeatureAPI {
}