package com.example.common_utils.di

import com.example.common_utils.time_utils.TimeProvider
import com.example.common_utils.time_utils.TimeProviderImpl
import com.example.common_utils.kotlin_coroutine_utils.DispatcherProvider
import com.example.common_utils.kotlin_coroutine_utils.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal abstract class CommonModule {

/*    @Singleton
    @Binds
    abstract fun provideDispatcherProvider(dispatcherProvider: DispatcherProviderImpl): DispatcherProvider

    @Singleton
    @Binds
    abstract fun provideTimeProvider(timeProvider: TimeProviderImpl): TimeProvider*/
}