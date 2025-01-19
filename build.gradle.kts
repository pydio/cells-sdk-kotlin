// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    kotlin("jvm") version "1.9.25" apply false
}

tasks.wrapper {
    gradleVersion = "8.7"
    distributionUrl = "https://services.gradle.org/distributions/gradle-${gradleVersion}-all.zip"
}