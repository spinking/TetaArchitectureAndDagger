//this class used as box for gradle.kts files
//this class need to be in buildSrc/src/main/kotlin/Config.kt
//this module need to have raw in this build.gradle.kts
/*

plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
}

* */


import Config.fileTreeFromConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.kotlin.dsl.DependencyHandlerScope

//android
const val gradleVer = "4.0.2"
const val kotlinVer = "1.4.30"
const val ktxVer = "1.3.2"
const val appcompatVer = "1.2.0"
const val materialVer = "1.3.0"
const val constraintLayoutVer = "2.0.4"

//tests
const val junitVer = "4.12"
const val junitTestVer = "1.1.2"
const val espressoVer = "3.3.0"

//dagger
const val daggerVer = "2.31.2"
const val jsr250Ver = "1.0"

//JavaRx
const val rxJavaVer = "2.2.19"
const val rxAndroidVer = "2.1.1"

val androidLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("fileTree", Pair(fileTreeFromConfig(mapOf("dir" to "libs", "include" to listOf("*.jar")))!!, "implementation"))
    put("kotlin", Pair("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVer", "implementation"))
    put("ktx", Pair("androidx.core:core-ktx:$ktxVer", "implementation"))
    put("appcompat", Pair("androidx.appcompat:appcompat:$appcompatVer", "implementation"))
    put("material", Pair("com.google.android.material:material:$materialVer", "implementation"))
    put("constraintlayout", Pair("androidx.constraintlayout:constraintlayout:$constraintLayoutVer", "implementation"))
}

val testLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("junit", Pair("junit:junit:$junitVer", "testImplementation"))
    put("junitAndroid", Pair("androidx.test.ext:junit:$junitTestVer", "androidTestImplementation"))
    put("espresso", Pair("androidx.test.espresso:espresso-core:$espressoVer", "androidTestImplementation"))
}

val diLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("jsr250", Pair("javax.annotation:jsr250-api:$jsr250Ver", "compileOnly"))
    put("dagger", Pair("com.google.dagger:dagger:$daggerVer", "implementation"))
    put("daggerCompiler", Pair("com.google.dagger:dagger-compiler:$daggerVer", "kapt"))
}

val javaRxLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("rxJava", Pair("io.reactivex.rxjava2:rxjava:$rxJavaVer", "implementation"))
    put("rxAndroid", Pair("com.google.dagger:dagger:$rxAndroidVer", "implementation"))
}

object Config {
    var project: Project? = null

    /**
     * Impl work as implementation operator
     *
     * @param depAndType Pair<String as "androidx.core:core-ktx:$ktxVer", String as "implementation">
     * @return [Dependency]
     */
    fun DependencyHandler.impl(depAndType: Pair<Any, String>): Dependency? {
        return project?.let { add(depAndType.second, depAndType.first) }
    }

    /**
     * Impl map with libs
     *
     * @param map String as "kotlin", Pair<String as"androidx.core:core-ktx:$ktxVer",String as "implementation">
     */
    fun DependencyHandlerScope.implMap(map: Map<String, Pair<Any, String>>) {
        map.values.forEach { impl(it) }
    }

    /**
     * work as fileTree in function in gradle file
     * implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
     */
    fun fileTreeFromConfig(args: Map<String, *>): ConfigurableFileTree? =
        project?.fileTree(args)
}