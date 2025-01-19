import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
    id("maven-publish")
    id("com.diffplug.spotless") version "7.0.2"
}

group = "com.pydio.kotlin"
version = "0.1.1-dev"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

buildscript {
    val spotlessVersion = "7.0.2"
    repositories {
        maven("https://repo1.maven.org/maven2")
    }

    dependencies {
        classpath("com.diffplug.spotless:spotless-plugin-gradle:$spotlessVersion")
    }
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        target("**/*.kt")
        ktfmt()
    }
    format("misc") {
        target("**/.gitignore", "**/*.md", "**/*.gradle")
        trimTrailingWhitespace()
        leadingTabsToSpaces(2)
        endWithNewline()
    }
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(libs.kotlin.stdlib.jdk8)
    implementation(libs.kotlin.reflect)
    implementation(libs.okhttp)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)

    implementation(awssdk.services.s3)

    implementation(platform("org.apache.logging.log4j:log4j-bom:2.24.3"))
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl")

    testImplementation(libs.kotlintest.junit5)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
