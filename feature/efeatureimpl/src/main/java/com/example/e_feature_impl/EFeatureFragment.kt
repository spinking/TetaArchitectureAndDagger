package com.example.e_feature_impl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.e_feature_impl.di.EFeatureComponent
import com.example.e_feature_impl.di.EFeatureComponentHolder
import com.example.e_feature_impl.viewmodel.EFeatureViewModel

class EFeatureFragment : Fragment() {

    private val viewModel: EFeatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (EFeatureComponentHolder.get() as EFeatureComponent).inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.e_feature_fragment, container, false)
    }

    companion object {
        fun newInstance() = EFeatureFragment()
    }
}