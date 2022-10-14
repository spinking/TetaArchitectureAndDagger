package com.example.a_feature_impl.network

import com.example.common_api.lce.lce
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AFeatureInteractor @Inject constructor(private val AFeatureRest: AFeatureRest) {
    fun getSomething(something: Int) = lce {
        AFeatureRest.getMains(something)
    }
}