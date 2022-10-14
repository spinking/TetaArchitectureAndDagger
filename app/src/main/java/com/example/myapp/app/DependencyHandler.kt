package com.example.myapp.app

import android.content.Context
import com.example.myapp.app.dependency_holders.core.AppHolderInjector.appInjection
import com.example.myapp.app.dependency_holders.core.CommonHolderInjector.commonInjection
import com.example.myapp.app.dependency_holders.core.DatabaseHolderInjector.databaseInjection
import com.example.myapp.app.dependency_holders.core.NetworkHolderInjector.networkInjection
import com.example.myapp.app.dependency_holders.feature.AFeatureHolderInjector.aFeatureInjection
import com.example.myapp.app.dependency_holders.feature.BFeatureHolderInjector.bFeatureInjection
import com.example.myapp.app.dependency_holders.feature.CFeatureHolderInjector.cFeatureInjection

object DependencyHandler {
    fun initDependency(appContext: Context){
        //app
        appInjection(appContext)
        //core
        commonInjection()
        databaseInjection()
        networkInjection()
        //feature
        aFeatureInjection()
        bFeatureInjection()
        cFeatureInjection()
    }
}