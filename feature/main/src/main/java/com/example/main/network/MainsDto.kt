package com.example.main.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MainsDto(
    val master: String?,
    val violet: String?
)
