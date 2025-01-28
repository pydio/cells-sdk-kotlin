pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven ("https://repo1.maven.org/maven2")
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "sdk-openapi-multiplatform"

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("awssdk") {
            from("aws.sdk.kotlin:version-catalog:1.3.112")
        }
    }
}
