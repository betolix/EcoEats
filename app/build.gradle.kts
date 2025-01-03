plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "io.h3llo.ecoeats"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.h3llo.ecoeats"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "URL_BASE", "\"http://betolix-001-site1.etempurl.com/\"")
        }
        debug {
            buildConfigField("String", "URL_BASE", "\"http://betolix-001-site1.etempurl.com/\"")
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // FIREBASE - FIRESTORE
    implementation(libs.firebase.firestore)
    implementation(libs.support.annotations)
    implementation(libs.firebase.storage)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//    //NAVIGATION COMPOSE
//    implementation ("androidx.navigation:navigation-compose:2.7.7")
    implementation ( libs.navigation.compose )
    implementation ( libs.kotlin.serialization.json )

    //PAGER
    implementation (libs.accompanist.pager)

    //ICONS
    implementation (libs.androidx.material.icons.extended)

    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    // INTERCEPTOR
    implementation(libs.logging.interceptor)


    // INTEGRACION DE VIEWMODEL EN COMPOSE
    //      implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    // NECESARIA PARA USAR viewModel() EN COMPOSABLES
    //      implementation("androidx.activity:activity-compose:1.7.2")

    // HILT - D.I.
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)

    // SECURITY - CRYPTO
    implementation(libs.androidx.security.crypto)

    // COIL
    implementation(libs.coil.compose)


    // collectAsStateWithLifecycle
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.8.6")

    // LOTTIE
    implementation("com.airbnb.android:lottie-compose:6.0.0")

    // PLACEHOLDER
    implementation("com.google.accompanist:accompanist-placeholder:0.24.13-rc")

    // LOTTIE
    implementation("com.airbnb.android:lottie-compose:6.0.0")

    // ROOM
    implementation("androidx.room:room-ktx:2.5.1")
    implementation("androidx.room:room-runtime:2.5.1")
    kapt("androidx.room:room-compiler:2.5.1")

    //WorkManager
    implementation("androidx.work:work-runtime-ktx:2.7.1")

    //Hilt-WorkManager
    implementation("androidx.hilt:hilt-work:1.0.0")

    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:2.7.1")







}