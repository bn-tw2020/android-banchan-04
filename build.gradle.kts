// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version ("7.2.1") apply (false)
    id("com.android.library") version ("7.2.1") apply (false)
    id("org.jetbrains.kotlin.android") version ("1.6.10") apply (false)
    id("org.jetbrains.kotlin.jvm") version ("1.6.10") apply (false)
    id("org.jlleitschuh.gradle.ktlint") version ("10.3.0") apply (false)
}
buildscript {
    dependencies {
        classpath(Lib.Hilt.androidGradlePlugin)
        classpath(Lib.KtLint.ktLintGradle)
        classpath(Lib.Firebase.googleService)
        classpath(Lib.Firebase.firebaseCrashlyticsGradle)
    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}