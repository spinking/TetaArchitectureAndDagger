package com.example.myapp.app.dependency_holders

import com.example.common_utils.di.CommonComponentHolder
import com.example.common_utils.di.CommonFeatureDependencies
import com.example.common_utils.logs.Logger
import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeature

object CommonHolderInjector {
    fun commonDependencyHolderInject(){
        CommonComponentHolder.dependencyProvider = {
            class CommonComponentDependencyHolder(
                override val block: (BaseDependencyHolder<CommonFeatureDependencies>, api1: AppFeature) -> CommonFeatureDependencies
            ) : DependencyHolder1<AppFeature, CommonFeatureDependencies>(api1 = AppComponentHolder.get())

            CommonComponentDependencyHolder { dependencyHolder, appApi ->
                object : CommonFeatureDependencies {
                    override val logger: Logger = appApi.logger
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}