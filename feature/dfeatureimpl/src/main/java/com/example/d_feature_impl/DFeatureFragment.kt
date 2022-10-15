package com.example.d_feature_impl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.d_feature_impl.R
import com.example.d_feature_impl.di.DFeatureComponent
import com.example.d_feature_impl.di.DFeatureComponentHolder
import com.example.d_feature_impl.viewmodel.DFeatureViewModel

class DFeatureFragment : Fragment() {

    private val viewModel: DFeatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (DFeatureComponentHolder.get() as DFeatureComponent).inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.d_feature_fragment, container, false)
    }

    companion object {
        fun newInstance() = DFeatureFragment()
    }
}