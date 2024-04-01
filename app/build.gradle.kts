plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    // Kapt
    kotlin("kapt")

    // Hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.android4_4"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.android4_4"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    // Binding
    buildFeatures.viewBinding = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("org.jetbrains:annotations:RELEASE_VERSION")

    //Retrofit_2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Binding property delegate
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.9")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Paging
    val paging_version = "3.2.1"
    implementation("androidx.paging:paging-runtime:$paging_version")

    // ViewModels
    implementation ("androidx.core:core-ktx:1.0.2")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.activity:activity-ktx")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx")
}