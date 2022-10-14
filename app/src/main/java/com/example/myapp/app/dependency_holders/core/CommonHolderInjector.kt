package com.example.myapp.app.dependency_holders.core

import com.example.common_impl.di.CommonComponentHolder
import com.example.common_impl.di.CommonFeatureDependencies
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi

object CommonHolderInjector {
    fun commonInjection(){
        CommonComponentHolder.dependencyProvider = {
            class CommonComponentDependencyHolder(
                override val block: (BaseDependencyHolder<CommonFeatureDependencies>, api1: AppFeatureApi) -> CommonFeatureDependencies
            ) : DependencyHolder1<AppFeatureApi, CommonFeatureDependencies>(api1 = AppComponentHolder.get())

            CommonComponentDependencyHolder { dependencyHolder, appApi ->
                object : CommonFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}