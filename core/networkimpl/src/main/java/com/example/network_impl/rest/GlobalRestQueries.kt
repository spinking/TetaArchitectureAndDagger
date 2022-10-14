package com.example.network_impl.rest

import com.example.network_api.dto.SshAnswer
import retrofit2.http.GET
import retrofit2.http.Query

interface GlobalQueries {
    @GET("getSshCode/{code}")
    suspend fun getSsh(
        @Query("code") postsId: Int
    ): SshAnswer
}