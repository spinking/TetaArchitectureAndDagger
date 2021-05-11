plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
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
}

fun String.get() =  rootProject.extra[this]
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":core:common_utils"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${"kotlin_ver".get()}")
    implementation("androidx.core:core-ktx:${"ktx_ver".get()}")
    implementation("androidx.appcompat:appcompat:${"appcompat_ver".get()}")
    testImplementation("junit:junit:${"junit_ver".get()}")
    androidTestImplementation("androidx.test.ext:junit:${"junit_test_ver".get()}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${"espresso_ver".get()}")

    compileOnly("javax.annotation:jsr250-api:${"jsr250_ver".get()}")
    implementation("com.google.dagger:dagger:${"dagger_ver".get()}")
    kapt("com.google.dagger:dagger-compiler:${"dagger_ver".get()}")
}
