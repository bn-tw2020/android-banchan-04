object Version {
    const val core = "1.8.0"
    const val appcompat = "1.4.2"
    const val constraintLayout = "2.1.4"
    const val fragmentKtx = "1.3.3"
    const val googleMaterial = "1.6.1"
    const val recyclerview = "1.2.1"

    const val hilt = "2.38.1"

    const val junit4 = "4.13.2"
    const val androidxJunit = "1.1.3"
    const val espressoCore = "3.4.0"

    const val glide = "4.13.2"
}

object Lib {

    object Androidx {
        const val core = "androidx.core:core-ktx:${Version.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragmentKtx}"
        const val googleMaterial = "com.google.android.material:material:${Version.googleMaterial}"

        const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"

        const val recyclerview = "androidx.recyclerview:recyclerview:${Version.recyclerview}"
    }

    object Hilt {
        const val androidGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
        const val android = "com.google.dagger:hilt-android:${Version.hilt}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
        const val core = "com.google.dagger:hilt-core:${Version.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
    }

    object Test {
        const val junit4 = "junit:junit:${Version.junit4}"
        const val androidxJunit = "androidx.test.ext:junit:${Version.androidxJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    }
}