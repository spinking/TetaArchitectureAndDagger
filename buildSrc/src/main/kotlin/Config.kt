/**
 *  plugins {
 *      `kotlin-dsl`
 *  }
 *
 *  repositories {
 *      jcenter()
 *  }
 *
 * this class used as box for gradle.kts files
 * this class need to be in buildSrc/src/main/kotlin/Config.kt
 * this module need to have raw in this build.gradle.kts
 */

import Config.fileTreeFromConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.kotlin.dsl.DependencyHandlerScope

//system
const val gradleConfVer = "4.0.2"
const val minSdkVersionConf = 21
const val compileSdkVersionConf = 30
const val appVersionCodeConf = 1
const val appVersionNameConf = "1.0.0"
const val appIdConf = "com.example.new.dagger_arch"
const val testInstrumentRunnerConf = "androidx.test.runner.AndroidJUnitRunner"

//android
const val appcompatVer = "1.2.0"
const val materialVer = "1.3.0"
const val constraintLayoutVer = "2.0.4"
const val materialDateTimePickerVer = "4.2.1"

//kotlin
const val kotlinVer = "1.4.30"
const val ktxVer = "1.3.2"
const val coroutinesVer = "1.3.9"

//tests
const val junitVer = "4.12"
const val junitTestVer = "1.1.2"
const val espressoVer = "3.3.0"
const val kaspressoVer = "1.2.0"

//dagger
const val daggerVer = "2.31.2"
const val jsr250Ver = "1.0"

//JavaRx
const val rxJavaVer = "2.2.19"
const val rxAndroidVer = "2.1.1"

const val rxLintVer = "1.7.7"
const val rxJava2ExtentionVer = "0.20.10"

//lottie
const val lottieVer = "3.1.0"

//network
const val squareupOkhttpVer = "4.6.0"

//picasso
const val squareupPicassoVer = "2.71828"

//video
const val youtubeVer = "1.2.2"
const val exoplayerVer = "2.11.8"

//lint
const val lintVer = "26.5.1"

//websocket
const val websocketVer = "2.6"

val androidLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("fileTree", Pair(fileTreeFromConfig(mapOf("dir" to "libs", "include" to listOf("*.jar")))!!, "implementation"))
    put("appcompat", Pair("androidx.appcompat:appcompat:$appcompatVer", "implementation"))
    put("material", Pair("com.google.android.material:material:$materialVer", "implementation"))
    put("constraintlayout", Pair("androidx.constraintlayout:constraintlayout:$constraintLayoutVer", "implementation"))
    put(
        "materialDateTimePicker",
        Pair("com.wdullaer:materialdatetimepicker:$materialDateTimePickerVer", "implementation")
    )
}

val kotlinLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("kotlin", Pair("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVer", "implementation"))
    put("ktx", Pair("androidx.core:core-ktx:$ktxVer", "implementation"))
    put("coroutines", Pair("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVer", "implementation"))
    put("coroutinesAndroid", Pair("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVer", "implementation"))
    put("coroutinesTest", Pair("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVer", "testImplementation"))
}

val testLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("junit", Pair("junit:junit:$junitVer", "testImplementation"))
    put("junitAndroid", Pair("androidx.test.ext:junit:$junitTestVer", "androidTestImplementation"))
    put("espresso", Pair("androidx.test.espresso:espresso-core:$espressoVer", "androidTestImplementation"))
    put("kaspresso", Pair("com.kaspersky.android-components:kaspresso:$kaspressoVer", "testImplementation"))

}

val diLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("jsr250", Pair("javax.annotation:jsr250-api:$jsr250Ver", "compileOnly"))
    put("dagger", Pair("com.google.dagger:dagger:$daggerVer", "implementation"))
    put("daggerCompiler", Pair("com.google.dagger:dagger-compiler:$daggerVer", "kapt"))
}

val javaRxLibs = mutableMapOf<String, Pair<Any, String>>().apply {
    put("rxJava", Pair("io.reactivex.rxjava2:rxjava:$rxJavaVer", "implementation"))
    put("rxAndroid", Pair("com.google.dagger:dagger:$rxAndroidVer", "implementation"))
    put("rxLint", Pair("nl.littlerobots.rxlint:rxlint:$rxLintVer", "implementation"))
    put("rxJava2Extention", Pair("com.github.akarnokd:rxjava2-extensions:$rxJava2ExtentionVer", "implementation"))

}

val exoplayer = mutableMapOf<String, Pair<Any, String>>().apply {
    put("exoPlayerCore", Pair("com.google.android.exoplayer:exoplayer-core:$exoplayerVer", "implementation"))
    put("exoPlayerUi", Pair("com.google.android.exoplayer:exoplayer-ui:$exoplayerVer", "implementation"))
    put("exoPlayerHls", Pair("com.google.android.exoplayer:exoplayer-hls:$exoplayerVer", "implementation"))
    put("exoPlayerOkHttp", Pair("com.google.android.exoplayer:extension-okhttp:$exoplayerVer", "implementation"))
}

val lint = mutableMapOf<String, Pair<Any, String>>().apply {
    put("api", Pair("com.android.tools.lint:lint-api:$lintVer", "implementation"))
    put("checks", Pair("com.android.tools.lint:lint-checks:$lintVer", "implementation"))
    put("tests", Pair("com.android.tools.lint:lint-tests:$lintVer", "implementation"))
}

val lottie = Pair<Any, String>("com.airbnb.android:lottie:$lottieVer", "implementation")
val squareupOkhttp = Pair<Any, String>("com.squareup.okhttp3:okhttp:$squareupOkhttpVer", "implementation")
val squareupPicasso = Pair<Any, String>("com.squareup.picasso:picasso:$squareupPicassoVer", "implementation")
val youtube = Pair<Any, String>("com.google.youtube:YouTubeAndroidPlayerApi:$youtubeVer", "implementation")
val websocket = Pair<Any, String>("com.neovisionaries:nv-websocket-client:$websocketVer", "implementation")

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