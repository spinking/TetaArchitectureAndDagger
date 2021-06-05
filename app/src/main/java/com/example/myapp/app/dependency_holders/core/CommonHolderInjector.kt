package com.example.myapp.app.dependency_holders.core

import com.example.common_utils.di.CommonComponentHolder
import com.example.common_utils.di.CommonFeatureDependencies
import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi

object CommonHolderInjector {
    fun common_Injection(){
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