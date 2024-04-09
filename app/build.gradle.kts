plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.androidtechnicalexamination"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidtechnicalexamination"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.sqlite.ktx)
    ksp(libs.room.compiler)

    implementation(libs.retrofit2)
    implementation(libs.converter.gson)
    implementation(libs.interceptor)
    implementation(libs.retrofit.adapter)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlin.serialization)

    implementation(libs.timber.logging)
    implementation(libs.androidx.livedata)
    implementation(libs.androidx.viewmodel)

    implementation(libs.devtools.ksp)

    implementation(libs.picasso)

    implementation(libs.swiperefresh)
}