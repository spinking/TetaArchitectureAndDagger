package com.example.network_api.dto

import retrofit2.http.GET
import retrofit2.http.Query

data class SshAnswer(
    val sshCryptAnswer: String? = null
)