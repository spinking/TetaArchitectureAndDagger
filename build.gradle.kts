buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        Config.project = rootProject // need to use empty extentions in buildSrc/.../Config.kt
        classpath("com.android.tools.build:gradle:$gradleVer")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVer")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts.kts.kts.ktx files
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

