package com.example.main.di


import com.example.main.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [MainFeatureDependencies::class], modules = [MainModule::class,MainModule2::class])
@Singleton
internal interface MainComponent : MainFeatureApi {

   fun inject(viewModel: MainViewModel)

    companion object {
        fun initAndGet(commonDependencies: MainFeatureDependencies): MainComponent {
            return DaggerMainComponent.builder()
                .mainFeatureDependencies(commonDependencies)
                .build()
        }
    }
}
