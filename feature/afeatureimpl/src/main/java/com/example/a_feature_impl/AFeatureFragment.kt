package com.example.a_feature_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.a_feature_impl.di.AFeatureComponent
import com.example.a_feature_impl.di.AFeatureComponentHolder
import com.example.common_api.fragment.ScopedFragment
import com.example.a_feature_impl.viewmodel.AFeatureViewModel

class AFeatureFragment : ScopedFragment() {

    private val viewModel: AFeatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        (AFeatureComponentHolder.get() as AFeatureComponent).inject(viewModel)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.a_feature_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(2)
    }

    companion object {
        fun getInstance() = AFeatureFragment()
    }
}