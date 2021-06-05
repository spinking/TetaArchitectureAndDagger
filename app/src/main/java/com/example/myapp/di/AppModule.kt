package com.example.myapp.di

import com.example.common_utils.time_utils.TimeProvider
import com.example.common_utils.time_utils.TimeProviderImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun provideTimeProvider(timeProvider: TimeProviderImpl): TimeProvider
}