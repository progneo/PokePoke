plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.daggerAndroid)
    alias(libs.plugins.ksp)
}

android {
    namespace = "me.progneo.pokepoke"
    compileSdk = 34

    defaultConfig {
        applicationId = "me.progneo.megashop"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.commonCore)
    implementation(projects.commonPresentation)
    implementation(projects.network)

    implementation(projects.datasourceApi)
    implementation(projects.datasourceImpl)

    implementation(projects.homeDomain)
    implementation(projects.homeData)
    implementation(projects.homePresentation)

    implementation(projects.detailDomain)
    implementation(projects.detailData)
    implementation(projects.detailPresentation)

    // lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // hilt
    implementation(libs.dagger.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.dagger.hilt.compiler)

    // coil
    implementation(libs.coil)
    implementation(libs.coil.compose)
}
