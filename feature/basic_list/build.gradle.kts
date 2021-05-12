import Config.implMap

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {

    defaultConfig {
        compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
        minSdkVersion(rootProject.extra["minSdkVersion"] as Int)
        targetSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
        versionCode = rootProject.extra["appVersionCode"] as Int
        versionName = rootProject.extra["appVersionName"] as String
        testInstrumentationRunner = rootProject.extra["testInstrumentRunner"] as String
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
            proguardFiles("proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":core:common_utils"))

    implMap(androidLibs)
    implMap(testLibs)
    implMap(diLibs)
    implMap(javaRxLibs)
}
