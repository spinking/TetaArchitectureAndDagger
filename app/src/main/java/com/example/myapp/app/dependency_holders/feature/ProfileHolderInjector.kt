package com.example.myapp.app.dependency_holders.feature

import com.example.common_utils.modul_injection.BaseDependencyHolder
import com.example.common_utils.modul_injection.BaseFeatureDependencies
import com.example.common_utils.modul_injection.DependencyHolder1
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi
import com.example.profile.di.ProfileComponentHolder
import com.example.profile.di.ProfileFeatureDependencies

object ProfileHolderInjector {
    fun profile_Injection(){
        ProfileComponentHolder.dependencyProvider = {
            class ProfileComponentDependencyHolder(
                override val block: (BaseDependencyHolder<ProfileFeatureDependencies>, api1: AppFeatureApi) -> ProfileFeatureDependencies
            ) : DependencyHolder1<AppFeatureApi, ProfileFeatureDependencies>(api1 = AppComponentHolder.get())

            ProfileComponentDependencyHolder { dependencyHolder, appApi ->
                object : ProfileFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}