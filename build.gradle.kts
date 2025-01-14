// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val nav_version = "2.7.7"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}


plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false // Sesuaikan versi Kotlin sesuai kebutuhan
}