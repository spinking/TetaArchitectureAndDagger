package com.example.myapp.app.dependency_holders.feature

import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi
import com.example.c_feature_impl.di.CFeatureComponentHolder
import com.example.c_feature_impl.di.CFeatureDependencies

object CFeatureHolderInjector {
    fun cFeatureInjection(){
        CFeatureComponentHolder.dependencyProvider = {
            class CFeatureComponentDependencyHolder(
                override val block: (BaseDependencyHolder<CFeatureDependencies>, api1: AppFeatureApi) -> CFeatureDependencies
            ) : DependencyHolder1<AppFeatureApi, CFeatureDependencies>(api1 = AppComponentHolder.get())

            CFeatureComponentDependencyHolder { dependencyHolder, appApi ->
                object : CFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}