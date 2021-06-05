
//import Config.implMap
/*
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }//need to use viewModel
    compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
    defaultConfig {
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
    flavorDimensions("main")
    productFlavors {
        create("prod") {
            buildConfigField("String", "BASE_SERVER", "\"https://mycorp.com\"")

        }
        create("dev") {
            applicationIdSuffix = applicationIdSuffixConf//".dev"
            versionNameSuffix = versionNameSuffixConf//"-dev"
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
        //core
        implementation(project(":core:common_utils"))
        implementation(project(":core:database"))
        implementation(project(":core:network"))
        //feature
        implementation(project(":feature:main"))
        implementation(project(":feature:onboarding"))
        implementation(project(":feature:profile"))

        implMap(androidXLibs)
        implMap(androidMaterial)
        implMap(kotlinLibs)
        implMap(testLibs)
        implMap(diLibs)
    }
}
*/

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

android {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }//need to use viewModel

    compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)

    defaultConfig {
        applicationId = "com.example.myapp"
        minSdkVersion(rootProject.extra["minSdkVersion"] as Int)
        targetSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
        versionCode = rootProject.extra["appVersionCode"] as Int
        versionName = rootProject.extra["appVersionName"] as String
        testInstrumentationRunner = rootProject.extra["testInstrumentRunner"] as String
    }

    flavorDimensions("main")
    productFlavors {
        create("prod") {
            buildConfigField("String", "BASE_SERVER", "\"https://mycorp.com\"")

        }
        create("dev") {
            applicationIdSuffix = applicationIdSuffixConf//".dev"
            versionNameSuffix = versionNameSuffixConf//"-dev"
            buildConfigField("String", "BASE_SERVER", "\"https://dev.mycorp.com\"")
        }
    }
    variantFilter {
        this.ignore = name == "prodDebug" || name == "devRelease"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
initLibDependencies()
dependencies {
    //core
    implementation(project(":core:common_utils"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))
    //feature
    implementation(project(":feature:main"))
    implementation(project(":feature:onboarding"))
    implementation(project(":feature:profile"))
}