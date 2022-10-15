plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}
android{
    compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }
}
initLibDependencies()
dependencies {
    implementation(project(":core:modulinjection"))
    implementation(project(":core:commonapi"))
    implementation(project(":feature:afeatureapi"))
    implementation(project(":feature:bfeatureapi"))
    implementation(project(":feature:cfeatureapi"))
}