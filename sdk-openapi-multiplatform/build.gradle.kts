import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform") version "1.9.23" // kotlin_version
    kotlin("plugin.serialization") version "1.9.23" // kotlin_version
}

group = "com.pydio.kotlin"
version = "0.1.1-dev"

repositories {
    mavenCentral()
}

kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.6.3")

                api("io.ktor:ktor-client-core:2.3.13")
                api("io.ktor:ktor-client-serialization:2.3.13")
                api("io.ktor:ktor-client-content-negotiation:2.3.13")
                api("io.ktor:ktor-serialization-kotlinx-json:2.3.13")
                api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
            }
        }

        commonTest.dependencies {
            implementation("org.jetbrains.kotlin:kotlin-test-common")
            implementation("io.ktor:ktor-client-okhttp:2.3.13")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
        }

        jvmMain {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("io.ktor:ktor-client-cio-jvm:2.3.13")
            }
        }

        jvmTest {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}
