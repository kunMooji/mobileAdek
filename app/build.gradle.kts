plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.profile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.profile"
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
}

dependencies {

    // Dependensi utama
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.cardview)


    // Menambahkan Volley Untuk Requst HTTP
    implementation("com.android.volley:volley:1.2.1")
    implementation(libs.gridlayout)
    implementation ("com.google.android.material:material:1.9.0")



    // Dependensi pengujian
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
