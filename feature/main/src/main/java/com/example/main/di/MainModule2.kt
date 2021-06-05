package com.example.main.di

import com.example.common_utils.kotlin_coroutine_utils.DispatcherProvider
import com.example.common_utils.time_utils.TimeProvider
import com.example.common_utils.time_utils.TimeProviderImpl
import com.example.main.network.MainApi
import com.example.main.network.MainInteractor
import com.example.network.impl.RetrofitProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule2 {
    @Singleton
    @Provides
    fun provideFeedApi(retrofit: RetrofitProvider) = retrofit.retrofit.create(MainApi::class.java)

    @Singleton
    @Provides
    fun provideMainInteractor(api: MainApi) = MainInteractor(api)
}