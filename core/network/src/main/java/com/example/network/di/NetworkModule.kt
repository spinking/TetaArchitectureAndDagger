package com.example.network.di

import com.example.network.impl.RetrofitProvider
import com.example.network.impl.RetrofitImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class NetworkModule {
    @Singleton
    @Binds
    abstract fun provideDispatcherProvider(retrofit: RetrofitImpl): RetrofitProvider
}