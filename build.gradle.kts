plugins { 
    id("com.android.application") version "8.0.0" 
    kotlin("kapt") version "1.8.0" 
}

android { 
    compileSdk = 34

    defaultConfig { 
        applicationId = "com.example.prayertimes"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes { 
        getByName("release") { 
            isMinified = false 
        } 
    }
    compileOptions { 
        sourceCompatibility JavaVersion.VERSION_1_8 
        targetCompatibility JavaVersion.VERSION_1_8 
    }
}

dependencies { 
    implementation("androidx.core:core-ktx:1.10.1") 
    implementation("androidx.appcompat:appcompat:1.7.0") 
    implementation("com.google.android.material:material:1.9.0") 
    // Compose dependencies 
    implementation("androidx.compose.ui:ui:1.5.0") 
    implementation("androidx.compose.material3:material3:1.5.0") 
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0") 
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1") 
    // Room Database dependencies 
    implementation("androidx.room:room-ktx:2.6.0") 
    kapt("androidx.room:room-compiler:2.6.0") 
    // Location Services 
    implementation("com.google.android.gms:play-services-location:21.0.1") 
}