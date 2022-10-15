package com.example.e_feature_impl.di

import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate


object EFeatureComponentHolder : ComponentHolder<EFeatureApi, EFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            EFeatureApi,
            EFeatureDependencies,
            EFeatureComponent> { dependencies: EFeatureDependencies ->
        EFeatureComponent.initAndGet(dependencies)
    }


    override var dependencyProvider: (() -> EFeatureDependencies)? by
    componentHolderDelegate::dependencyProvider

    override fun get(): EFeatureApi = componentHolderDelegate.getComponentImpl()
}

// то что инициализируется в холдере
interface EFeatureDependencies : BaseFeatureDependencies {
}

//то что инициализируется в модуле или древе модулей
interface EFeatureApi : BaseFeatureAPI {
}