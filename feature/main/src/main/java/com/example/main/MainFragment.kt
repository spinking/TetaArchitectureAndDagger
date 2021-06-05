package com.example.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.common_utils.fragment.ScopedFragment
import com.example.main.di.MainComponent
import com.example.main.viewmodel.MainViewModel
import com.example.main.di.MainComponentHolder

class MainFragment : ScopedFragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        MainComponentHolder.getComponent().inject(viewModel)
        super.onCreate(savedInstanceState)
        //(MainComponentHolder.get() as MainComponent).inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init()
    }

    companion object {
        fun getInstance() = MainFragment()
    }
}