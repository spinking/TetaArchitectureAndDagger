package com.example.myapp.app.dependency_holders.feature

import com.example.a_feature_impl.di.AFeatureApi
import com.example.a_feature_impl.di.AFeatureComponentHolder
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder1
import com.example.b_feature_impl.di.BFeatureComponentHolder
import com.example.b_feature_impl.di.BFeatureDependencies

object BFeatureHolderInjector {
    fun bFeatureInjection(){
        BFeatureComponentHolder.dependencyProvider = {
            class BFeatureComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<BFeatureDependencies>, api1: AFeatureApi) -> BFeatureDependencies
            ) : DependencyHolder1<AFeatureApi, BFeatureDependencies>(api1 = AFeatureComponentHolder.get())

            BFeatureComponentDependencyHolder { dependencyHolder, aFeatureApi ->
                object : BFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}