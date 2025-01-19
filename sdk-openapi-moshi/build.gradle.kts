import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.9.23"
    kotlin("jvm") version kotlinVersion
    application
    id("maven-publish")
    id("com.diffplug.spotless") version "6.25.0"
}

group = "org.sinou.android.kotlin"
version = "0.1.1-dev"
val kotlinVersion = "1.9.23"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.wrapper {
    gradleVersion = "8.7"
    distributionUrl = "https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip"
}

buildscript {

    val kotlinVersion = "1.9.23"
    val spotlessVersion = "6.25.0"
    repositories {
        maven("https://repo1.maven.org/maven2" )
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
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
        // leadingTabsToSpaces(2)
        endWithNewline()
    }
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation ("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation ("com.squareup.moshi:moshi-kotlin:1.15.1")
    implementation ("com.squareup.moshi:moshi-adapters:1.15.1")
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")
    testImplementation ("io.kotlintest:kotlintest-runner-junit5:3.4.2")

//    implementation(awssdk.services.s3)
//    implementation(platform("org.apache.logging.log4j:log4j-bom:2.24.3"))

//    implementation("org.apache.logging.log4j:log4j-slf4j2-impl")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    kotlinOptions.freeCompilerArgs += "-Xlint:-deprecation"
}
