plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("org.jlleitschuh.gradle.ktlint")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {

    implementation(Lib.Androidx.core)
    implementation(Lib.Androidx.appcompat)
    implementation(Lib.Androidx.googleMaterial)
    implementation(Lib.Androidx.constraintLayout)
    implementation(Lib.Androidx.recyclerview)
    implementation(Lib.Androidx.viewModel)
    implementation(Lib.Androidx.fragmentKtx)
    implementation(Lib.Androidx.activityKtx)
    implementation(Lib.Androidx.lifecycleRuntimeKtx)
    implementation(Lib.Androidx.workRuntimeKtx)
    testImplementation(Lib.Test.junit4)
    androidTestImplementation(Lib.Test.androidxJunit)
    androidTestImplementation(Lib.Test.espressoCore)
    androidTestImplementation(Lib.Test.truth)
    testImplementation(Lib.OkHttp3.mockWebServer)
    testImplementation(Lib.Test.mockk)
    testImplementation(Lib.Test.truth)

    implementation(Lib.Androidx.glide)
    kapt(Lib.Androidx.glideCompiler)
    implementation(Lib.Androidx.glideCompose)

    implementation(Lib.Hilt.android)
    kapt(Lib.Hilt.androidCompiler)
    kapt(Lib.Hilt.hiltCompiler)
    implementation(Lib.Hilt.hiltWorker)

    implementation(Lib.Coroutine.android)
    implementation(Lib.Coroutine.core)
    implementation(Lib.Coroutine.test)

    implementation(Lib.Moshi.moshi)
    implementation(Lib.OkHttp3.core)
    implementation(Lib.OkHttp3.loggingInterceptor)

    implementation(Lib.Retrofit.core)
    implementation(Lib.Retrofit.moshiConverter)

    implementation(Lib.Compose.compose)
    implementation(Lib.Compose.material)
    implementation(Lib.Compose.animation)
    implementation(Lib.Compose.viewModel)
    implementation(Lib.Compose.tooling)
    androidTestImplementation(Lib.Compose.junit4)

    implementation(Lib.Room.runtime)
    kapt(Lib.Room.compiler)
    implementation(Lib.Room.roomKtx)
    implementation(Lib.Room.paging)
    implementation(Lib.Room.roomPaging)
    testImplementation(Lib.Room.test)

    implementation(platform(Lib.Firebase.firebaseBom))
    implementation(Lib.Firebase.firebaseAnalyticsKtx)
    implementation(Lib.Firebase.firebaseAnalytics)
    implementation(Lib.Firebase.firebaseCrashlytics)
}
