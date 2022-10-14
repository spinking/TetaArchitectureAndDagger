package com.example.b_feature_impl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.b_feature_impl.di.BFeatureComponent
import com.example.b_feature_impl.di.BFeatureComponentHolder
import com.example.b_feature_impl.viewmodel.BFeatureViewModel

class BFeatureFragment : Fragment() {

    private val viewModel: BFeatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (BFeatureComponentHolder.get() as BFeatureComponent).inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.b_feature_fragment, container, false)
    }

    companion object {
        fun newInstance() = BFeatureFragment()
    }
}