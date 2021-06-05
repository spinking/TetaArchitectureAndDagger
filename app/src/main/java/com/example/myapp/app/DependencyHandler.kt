package com.example.myapp.app

import android.content.Context
import com.example.myapp.app.dependency_holders.core.AppHolderInjector.app_Injection
import com.example.myapp.app.dependency_holders.core.CommonHolderInjector.common_Injection
import com.example.myapp.app.dependency_holders.core.DatabaseHolderInjector.database_Injection
import com.example.myapp.app.dependency_holders.core.NetworkHolderInjector.network_Injection
import com.example.myapp.app.dependency_holders.feature.MainHolderInjector.main_Injection
import com.example.myapp.app.dependency_holders.feature.OnboardingHolderInjector.onboarding_Injection
import com.example.myapp.app.dependency_holders.feature.ProfileHolderInjector.profile_Injection

object DependencyHandler {
    fun initDependency(appContext: Context){
        //app
        app_Injection(appContext)
        //core
        common_Injection()
        database_Injection()
        network_Injection()
        //feature
        main_Injection()
        onboarding_Injection()
        profile_Injection()

    }
}