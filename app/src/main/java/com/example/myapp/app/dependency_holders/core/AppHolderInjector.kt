package com.example.myapp.app.dependency_holders.core

import android.content.Context
import com.example.common_utils.config.ConfigProvider
import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder0
import com.example.myapp.common.app.ApplicationProvider
import com.example.myapp.common.app.ApplicationProviderImpl
import com.example.myapp.common.config.BuildConfigProviderImpl
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureDependencies

object AppHolderInjector {
    fun app_Injection(appContext: Context) {
        AppComponentHolder.dependencyProvider = {
            class AppComponentDependencyHolder(
                override val block: (BaseDependencyHolder<AppFeatureDependencies>) -> AppFeatureDependencies
            ) : DependencyHolder0<AppFeatureDependencies>()

            AppComponentDependencyHolder { deps ->
                object : AppFeatureDependencies {
                    override val appProvider: ApplicationProvider =
                        ApplicationProviderImpl(appContext)
                    override val configProvider: ConfigProvider =
                        BuildConfigProviderImpl()
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = deps
                }
            }.dependencies
        }
    }
}