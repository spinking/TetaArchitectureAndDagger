package com.example.myapp.app

import android.content.Context
import com.example.myapp.app.dependency_holders.AppHolderInjector.appDependencyHolderInject
import com.example.myapp.app.dependency_holders.CommonHolderInjector.commonDependencyHolderInject

object DependencyHandler {
    fun initDependency(appContext: Context){
        appDependencyHolderInject(appContext)
        commonDependencyHolderInject()
    }
}