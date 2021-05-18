package com.example.myapp.di

import com.example.myapp.app.App
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [AppFeatureDependencies::class],
    modules = [ AppModule::class ]
)
@Singleton
interface AppComponent : AppFeature {
    fun inject(theApplication: App)

    interface Builder {
        fun build(): AppComponent
    }

    companion object {
        fun initAndGet(dependencies: AppFeatureDependencies): AppComponent {
            return DaggerAppComponent.builder()
                .appFeatureDependencies(dependencies)
                .build()
        }

    }
}