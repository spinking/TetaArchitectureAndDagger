package com.example.a_feature_impl.di

import com.example.common_api.time_utils.TimeProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class AFeatureModule1 {
//    @Singleton
//    @Binds
//    abstract fun provideDispatcherProvider(AFeatureProvider: CommonProviderApi): DispatcherProvider
//
//    @Singleton
//    @Binds
//    abstract fun provideTimeProvider(timeProvider: TimeProviderImpl): TimeProvider
}