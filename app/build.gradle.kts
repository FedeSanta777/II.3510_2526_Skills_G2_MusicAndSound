plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.skillsexercise"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.skillsexercise"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    // 👇 Allinea il compilatore Java a 17
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // 👇 Allinea il compilatore Kotlin a 17
    kotlinOptions {
        jvmTarget = "17"
    }

    // (opzionale ma consigliato) toolchain Kotlin
    // richiede Gradle 7.6+ / AGP 8+
    // kotlin { jvmToolchain(17) }

    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.5.14" }
}


dependencies {
    val composeUi = "1.7.5"
    val material3 = "1.3.0"
    val activity = "1.9.3"

    implementation("androidx.activity:activity-compose:$activity")
    implementation("androidx.compose.ui:ui:$composeUi")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeUi")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeUi")
    implementation("androidx.compose.material3:material3:$material3")
    implementation("androidx.compose.material:material-icons-extended:$composeUi")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
}
