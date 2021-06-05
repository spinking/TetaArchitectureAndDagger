package com.example.database.di


import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [DatabaseFeatureDependencies::class], modules = [DatabaseModule::class])
@Singleton
internal interface DatabaseComponent : DatabaseFeatureApi {

    companion object {
        fun initAndGet(databaseDependencies: DatabaseFeatureDependencies): DatabaseComponent {
            return DaggerDatabaseComponent.builder()
                .databaseFeatureDependencies(databaseDependencies)
                .build()
        }
    }
}
