package com.example.myapp.app.dependency_holders.feature

import com.example.a_feature_impl.di.AFeatureApi
import com.example.a_feature_impl.di.AFeatureComponentHolder
import com.example.b_feature_impl.di.BFeatureApi
import com.example.b_feature_impl.di.BFeatureComponentHolder
import com.example.c_feature_impl.di.CFeatureApi
import com.example.c_feature_impl.di.CFeatureComponentHolder
import com.example.d_feature_impl.di.DFeatureApi
import com.example.d_feature_impl.di.DFeatureComponentHolder
import com.example.e_feature_impl.di.EFeatureComponentHolder
import com.example.e_feature_impl.di.EFeatureDependencies
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder4

object EFeatureHolderInjector {
    fun eFeatureInjection() {
        EFeatureComponentHolder.dependencyProvider = {
            class EFeatureComponentDependencyHolder(
                override val block: (dependencyHolder: BaseDependencyHolder<EFeatureDependencies>, AFeatureApi, BFeatureApi, CFeatureApi, DFeatureApi) -> EFeatureDependencies
            ) : DependencyHolder4<AFeatureApi, BFeatureApi, CFeatureApi, DFeatureApi, EFeatureDependencies>(
                api1 = AFeatureComponentHolder.get(),
                api2 = BFeatureComponentHolder.get(),
                api3 = CFeatureComponentHolder.get(),
                api4 = DFeatureComponentHolder.get()
            )

            EFeatureComponentDependencyHolder { dependencyHolder, aFeatureApi, bFeatureApi, cFeatureApi, dFeatureApi ->
                object : EFeatureDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> = dependencyHolder
                }
            }.dependencies
        }
    }
}