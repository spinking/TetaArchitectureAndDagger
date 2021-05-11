buildscript {
    val kotlin_ver by extra("1.4.30")
    val gradle_ver by extra("4.0.2")
    val ktx_ver by extra("1.3.2")
    val junit_ver by extra("4.12")
    val junit_test_ver by extra("1.1.2")
    val espresso_ver by extra("3.3.0")
    val appcompat_ver by extra("1.2.0")
    val dagger_ver by extra("2.31.2")
    val jsr250_ver by extra("1.0")
    val rxJava_ver by extra("2.2.19")
    val rxAndroid_ver by extra("2.1.1")
    val cicerone_ver by extra("5.1.1")
    val material_ver by extra("1.3.0")
    val constraintlayout_ver by extra("2.0.4")

    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$gradle_ver")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_ver")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts.kts.ktx files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
    val minSdkVersion by extra(21)
    val compileSdkVersion by extra(30)
    val appVersionCode by extra(1)
    val appVersionName by extra("1.0.0")
    val testInstrumentRunner by extra("androidx.test.runner.AndroidJUnitRunner")
    val appId by extra("com.example.new.dagger_arch")
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

