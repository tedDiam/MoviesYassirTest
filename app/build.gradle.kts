plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.sergediame.moviesyassirtest"
        minSdk =  21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary =  true
        }
        buildConfigField("String", "IMAGE_BASE_URL", "\"https://image.tmdb.org/t/p/w500/\"")
        buildConfigField("String", "LANDSCAPE_IMAGE_BASE_URL", "\"https://image.tmdb.org/t/p/original/\"")

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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =  "1.2.0"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation (project(":domain"))
    implementation (project(":data"))

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Hilt DI
    implementation ("com.google.dagger:hilt-android:2.43.2")
    kapt ("com.google.dagger:hilt-compiler:2.43.2")

    //Navigation
    implementation ("androidx.navigation:navigation-compose:2.5.2")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    //Compose
    implementation ("androidx.compose.ui:ui:1.2.1")
    implementation ("androidx.compose.material:material:1.2.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation ("androidx.activity:activity-compose:1.6.0")
    implementation ("androidx.compose.compiler:compiler:1.3.1")

    implementation ("io.coil-kt:coil-compose:2.2.1")
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.25.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.2.1")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.2.1")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.2.1")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    implementation ("com.jakewharton.timber:timber:5.0.1")

    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.5.1")
    implementation ("com.google.android.material:material:1.6.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}