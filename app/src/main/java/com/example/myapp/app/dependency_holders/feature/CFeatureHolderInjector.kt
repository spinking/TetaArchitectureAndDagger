package com.example.myapp.app.dependency_holders.feature

import com.example.b_feature_impl.di.BFeatureApi
import com.example.b_feature_impl.di.BFeatureComponentHolder
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder1
import com.example.c_feature_impl.di.CFeatureComponentHolder
import com.example.c_feature_impl.di.CFeatureDependencies

object CFeatureHolderInjector {
    fun cFeatureInjection(){
        CFeatureComponentHolder.dependencyProvider = {
            class CFeatureComponentDependencyHolder(
                override val block: (BaseDependencyHolder<CFeatureDependencies>, api1: BFeatureApi) -> CFeatureDependencies
            ) : DependencyHolder1<BFeatureApi, CFeatureDependencies>(api1 = BFeatureComponentHolder.get())

            CFeatureComponentDependencyHolder { dependencyHolder, bFeatureApi ->
                object : CFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}