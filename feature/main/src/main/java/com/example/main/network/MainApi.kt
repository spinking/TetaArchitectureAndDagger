package com.example.main.network

import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("users/posts/links/{postsId}")
    suspend fun getMains(
        @Query("postsId") postsId: Int
    ): MainsDto
}