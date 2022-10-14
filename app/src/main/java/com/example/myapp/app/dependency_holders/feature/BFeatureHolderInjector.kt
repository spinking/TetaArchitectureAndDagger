package com.example.myapp.app.dependency_holders.feature

import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi
import com.example.b_feature_impl.di.BFeatureComponentHolder
import com.example.b_feature_impl.di.BFeatureDependencies

object BFeatureHolderInjector {
    fun bFeatureInjection(){
        BFeatureComponentHolder.dependencyProvider = {
            class BFeatureComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<BFeatureDependencies>, api1:
                AppFeatureApi) -> BFeatureDependencies
            ) : DependencyHolder1<AppFeatureApi, BFeatureDependencies>(api1 = AppComponentHolder.get())

            BFeatureComponentDependencyHolder { dependencyHolder, appApi ->
                object : BFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}