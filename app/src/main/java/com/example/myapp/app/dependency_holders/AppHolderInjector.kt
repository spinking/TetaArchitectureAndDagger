package com.example.myapp.app.dependency_holders

import android.content.Context
import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder0
import com.example.myapp.common.ApplicationProvider
import com.example.myapp.common.ApplicationProviderImpl
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureDependencies

object AppHolderInjector {
    fun appDependencyHolderInject(appContext: Context) {
        AppComponentHolder.dependencyProvider = {
            class AppComponentDependencyHolder(
                override val block: (BaseDependencyHolder<AppFeatureDependencies>) -> AppFeatureDependencies
            ) : DependencyHolder0<AppFeatureDependencies>()

            AppComponentDependencyHolder { deps ->
                object : AppFeatureDependencies {
                    override val appProvider: ApplicationProvider = ApplicationProviderImpl(appContext)
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = deps
                }
            }.dependencies
        }
    }
}