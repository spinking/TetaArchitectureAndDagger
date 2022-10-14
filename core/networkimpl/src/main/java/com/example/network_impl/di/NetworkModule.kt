package com.example.network_impl.di

import com.example.network_api.RetrofitProvider
import com.example.network_impl.impl.RetrofitImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class NetworkModule {
    @Singleton
    @Binds
    abstract fun provideDispatcherProvider(retrofit: RetrofitImpl): RetrofitProvider
}