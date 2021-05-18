package com.example.myapp.di

import com.example.common_utils.logs.Logger
import com.example.myapp.common.LoggerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun provideLogger(logger: LoggerImpl): Logger
}