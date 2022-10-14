buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:$gradleConfVer")
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
    val minSdkVersion by extra(minSdkVersionConf)
    val compileSdkVersion by extra(compileSdkVersionConf)
    val appVersionCode by extra(appVersionCodeConf)
    val appVersionName by extra(appVersionNameConf)
    val testInstrumentRunner by extra(testInstrumentRunnerConf)
    val appId by extra(appIdConf)
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

gradle.taskGraph.whenReady(closureOf<TaskExecutionGraph> {
    allTasks.forEach { task ->
        if (task.name.contains("lint")) {
            task.enabled = false
            logger.log(LogLevel.WARN, "${task.name} has been disabled")
        }
    }
})


