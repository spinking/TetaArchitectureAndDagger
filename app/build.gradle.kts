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
    implementation(project(":core:modulinjection"))

    //core
    implementation(project(":core:database"))
    implementation(project(":core:commonimpl"))
    implementation(project(":core:commonapi"))
    implementation(project(":core:networkimpl"))
    implementation(project(":core:networkapi"))
    implementation(project(":feature:afeatureimpl"))
    implementation(project(":feature:bfeatureimpl"))
    implementation(project(":feature:cfeatureimpl"))


    //feature
}