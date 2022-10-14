package com.example.a_feature_impl.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a_feature_impl.network.AFeatureInteractor
import com.example.common_api.time_utils.TimeProvider
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class AFeatureViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
//    @Inject
//    lateinit var dp: DispatcherProvider

//    @Inject
//    lateinit var tp: TimeProvider

    @Inject
    lateinit var iteractor: AFeatureInteractor

    fun init(a:Int) {
        viewModelScope.launch {
            iteractor.getSomething(a).collect {
                it.data?.let { }
            }
        }
    }
}