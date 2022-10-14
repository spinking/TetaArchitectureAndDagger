package com.example.c_feature_impl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.c_feature_impl.di.CFeatureComponent
import com.example.c_feature_impl.di.CFeatureComponentHolder
import com.example.c_feature_impl.viewmodel.CFeatureViewModel

class CFeatureFragment : Fragment() {

    private val viewModel: CFeatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (CFeatureComponentHolder.get() as CFeatureComponent).inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.c_feature_fragment, container, false)
    }

    companion object {
        fun newInstance() = CFeatureFragment()
    }
}