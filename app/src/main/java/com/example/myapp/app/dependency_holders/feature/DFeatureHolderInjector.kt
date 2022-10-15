package com.example.myapp.app.dependency_holders.feature

import com.example.a_feature_impl.di.AFeatureApi
import com.example.a_feature_impl.di.AFeatureComponentHolder
import com.example.b_feature_impl.di.BFeatureApi
import com.example.b_feature_impl.di.BFeatureComponentHolder
import com.example.c_feature_impl.di.CFeatureApi
import com.example.c_feature_impl.di.CFeatureComponentHolder
import com.example.d_feature_impl.di.DFeatureComponentHolder
import com.example.d_feature_impl.di.DFeatureDependencies
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder3

object DFeatureHolderInjector {
    fun dFeatureInjection() {
        DFeatureComponentHolder.dependencyProvider = {
            class DFeatureComponentDependencyHolder(
                override val block: (dependencyHolder: BaseDependencyHolder<DFeatureDependencies>, AFeatureApi, BFeatureApi, CFeatureApi) -> DFeatureDependencies
            ) : DependencyHolder3<AFeatureApi, BFeatureApi, CFeatureApi, DFeatureDependencies>(
                api1 = AFeatureComponentHolder.get(),
                api2 = BFeatureComponentHolder.get(),
                api3 = CFeatureComponentHolder.get()
            )

            DFeatureComponentDependencyHolder { dependencyHolder, aFeatureApi, bFeatureApi, cFeatureApi ->
                object : DFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}