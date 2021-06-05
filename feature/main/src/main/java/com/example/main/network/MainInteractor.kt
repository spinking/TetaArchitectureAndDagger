package com.example.main.network

import com.example.common_utils.lce.lce
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainInteractor @Inject constructor(private val mainApi: MainApi) {
    fun getSomething(something: Int) = lce {
        mainApi.getMains(something)
    }
}