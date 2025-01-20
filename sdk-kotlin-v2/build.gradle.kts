import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("maven-publish")
    kotlin("jvm")
    application
}

group = "com.pydio.kotlin"
version = "0.1.1-dev"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":sdk-openapi"))

    implementation(libs.kotlin.stdlib.jdk8)
    implementation(libs.kotlin.reflect)

    implementation(libs.okhttp)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)

    implementation(awssdk.services.s3)

    testImplementation(libs.kotlintest.junit5)
//    implementation(platform(libs.log4j.bom))
//    implementation(libs.log4j.impl)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
