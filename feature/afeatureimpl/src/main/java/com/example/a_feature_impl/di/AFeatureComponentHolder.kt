package com.example.a_feature_impl.di

import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate
import com.example.network_api.RetrofitProvider

object AFeatureComponentHolder : ComponentHolder<AFeatureApi, AFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            AFeatureApi,
            AFeatureDependencies,
            AFeatureComponent> { dependencies: AFeatureDependencies ->
        AFeatureComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> AFeatureDependencies)? by
    componentHolderDelegate::dependencyProvider

    override fun get(): AFeatureApi = componentHolderDelegate.get()
}

// то что инициализируется в холдере
interface AFeatureDependencies : BaseFeatureDependencies {
    val retrofitProvider: RetrofitProvider

}
//то что инициализируется в модуле или древе модулей
interface AFeatureApi : BaseFeatureAPI {
   // val dispatcherProvider: DispatcherProvider
    //val timeProvider: TimeProvider
}
