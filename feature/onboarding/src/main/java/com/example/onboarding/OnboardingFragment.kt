package com.example.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.onboarding.di.OnboardingComponent
import com.example.onboarding.di.OnboardingComponentHolder
import com.example.onboarding.viewmodel.OnboardingViewModel

class OnboardingFragment : Fragment() {

    private val viewModel: OnboardingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (OnboardingComponentHolder.get() as OnboardingComponent).inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.onboarding_fragment, container, false)
    }

    companion object {
        fun newInstance() = OnboardingFragment()
    }
}