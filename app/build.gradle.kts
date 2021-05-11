plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)

    defaultConfig {
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

    fun String.get() = rootProject.extra[this]
    dependencies {
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        implementation(project(":core:common_utils"))
        implementation(project(":core:database"))
        implementation(project(":core:network"))

        implementation("org.jetbrains.kotlin:kotlin-stdlib:${"kotlin_ver".get()}")
        implementation("androidx.core:core-ktx:${"ktx_ver".get()}")

        implementation("androidx.appcompat:appcompat:${"appcompat_ver".get()}")
        implementation("com.google.android.material:material:${"material_ver".get()}")
        implementation("androidx.constraintlayout:constraintlayout:${"constraintlayout_ver".get()}")

        testImplementation("junit:junit:${"junit_ver".get()}")
        androidTestImplementation("androidx.test.ext:junit:${"junit_test_ver".get()}")
        androidTestImplementation("androidx.test.espresso:espresso-core:${"espresso_ver".get()}")

        // cicerone
        implementation("ru.terrakok.cicerone:cicerone:${"cicerone_ver".get()}")
        // dagger
        compileOnly("javax.annotation:jsr250-api:${"jsr250_ver".get()}")
        implementation("com.google.dagger:dagger:${"dagger_ver".get()}")
        kapt("com.google.dagger:dagger-compiler:${"dagger_ver".get()}")
        // RxJava
        implementation("io.reactivex.rxjava2:rxjava:${"rxJava_ver".get()}")
        implementation("io.reactivex.rxjava2:rxandroid:${"rxAndroid_ver".get()}")
    }
}
