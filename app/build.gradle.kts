import Config.implMap

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {

    defaultConfig {
        compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
        applicationId = rootProject.extra["appId"] as String
        minSdkVersion(rootProject.extra["minSdkVersion"] as Int)
        targetSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
        versionCode = rootProject.extra["appVersionCode"] as Int
        versionName = rootProject.extra["appVersionName"] as String

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
    flavorDimensions("main")
    productFlavors {
        create("prod") {
            buildConfigField("String", "BASE_SERVER", "\"https://mycorp.com\"")

        }
        create("dev") {
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            buildConfigField("String", "BASE_SERVER", "\"https://dev.mycorp.com\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    variantFilter {
        this.ignore = name == "prodDebug" || name == "devRelease"

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    dependencies {
        implementation(project(":core:common_utils"))
        implementation(project(":core:database"))
        implementation(project(":core:network"))

        implMap(androidLibs)
        implMap(testLibs)
        implMap(diLibs)
        implMap(javaRxLibs)
    }
}
