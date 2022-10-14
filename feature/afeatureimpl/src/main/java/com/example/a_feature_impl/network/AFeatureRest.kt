package com.example.a_feature_impl.network

import com.example.a_feature_api.network.AFeatureDto
import retrofit2.http.GET
import retrofit2.http.Query

interface AFeatureRest {
    @GET("users/posts/links/{postsId}")
    suspend fun getMains(
        @Query("postsId") postsId: Int
    ): AFeatureDto
}