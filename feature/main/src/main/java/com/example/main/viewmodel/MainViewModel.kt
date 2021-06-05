package com.example.main.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utils.kotlin_coroutine_utils.DispatcherProvider
import com.example.common_utils.time_utils.TimeProvider
import com.example.main.network.MainApi
import com.example.main.network.MainInteractor
import com.example.network.impl.RetrofitProvider
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    @Inject
    lateinit var dp: DispatcherProvider

    @Inject
    lateinit var tp: TimeProvider

    @Inject
    lateinit var iteractor: MainInteractor

    fun init() {
        viewModelScope.launch {
            iteractor.getSomething(1).collect {
                it.data?.let { }
            }
        }
    }
}