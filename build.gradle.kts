buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
    // menambahkan dependesi
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
}
