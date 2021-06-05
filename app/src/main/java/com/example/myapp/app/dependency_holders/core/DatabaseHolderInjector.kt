package com.example.myapp.app.dependency_holders.core

import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder1
import com.example.database.di.DatabaseComponentHolder
import com.example.database.di.DatabaseFeatureDependencies
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi

object DatabaseHolderInjector {
    fun database_Injection(){
        DatabaseComponentHolder.dependencyProvider = {
            class DatabaseComponentDependencyHolder(
                override val block: (BaseDependencyHolder<DatabaseFeatureDependencies>, api1: AppFeatureApi) -> DatabaseFeatureDependencies
            ) : DependencyHolder1<AppFeatureApi, DatabaseFeatureDependencies>(api1 = AppComponentHolder.get())

            DatabaseComponentDependencyHolder { dependencyHolder, appApi ->
                object : DatabaseFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}