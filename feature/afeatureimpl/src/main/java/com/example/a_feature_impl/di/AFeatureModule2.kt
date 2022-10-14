package com.example.a_feature_impl.di

import com.example.a_feature_impl.network.AFeatureRest
import com.example.network_api.RetrofitProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AFeatureModule2 {
    @Singleton
    @Provides
    fun provideFeedApi(retrofit: RetrofitProvider) = retrofit.retrofit.create(AFeatureRest::class.java)

//    @Singleton
//    @Provides
//    fun provideMainInteractor(rest: AFeatureRest) = AFeatureInteractor(rest)
}