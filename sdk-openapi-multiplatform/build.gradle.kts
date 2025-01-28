import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform") version "2.0.21" // kotlin_version
    kotlin("plugin.serialization") version "2.0.21" // kotlin_version
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
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.7,3")

                api("io.ktor:ktor-client-core:3.0.1")
                api("io.ktor:ktor-client-serialization:3.0.1")
                api("io.ktor:ktor-client-content-negotiation:3.0.1")
                api("io.ktor:ktor-serialization-kotlinx-json:3.0.1")

                api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")

//                 implementation(awssdk.services.s3)
//                 implementation(platform("org.apache.logging.log4j:log4j-bom:2.24.3"))
//                 implementation("org.apache.logging.log4j:log4j-slf4j2-impl")

            }
        }

//        commonTest {
//            dependencies {
//                implementation(kotlin("test"))
//                implementation("io.ktor:ktor-client-mock:3.0.1")
//                // implementation("io.kotlintest:kotlintest:2.0.7")
//            }
//        }

        commonTest.dependencies {

            implementation("org.jetbrains.kotlin:kotlin-test-common")
            implementation("io.ktor:ktor-client-okhttp:3.0.1")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0")
//                implementation(kotlin("test"))
//                implementation("io.ktor:ktor-client-mock:3.0.1")
                // implementation("io.kotlintest:kotlintest:2.0.7")

        }


        jvmMain {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("io.ktor:ktor-client-cio-jvm:3.0.1")
                implementation("io.ktor:ktor-client-cio-jvm:3.0.1")
            }
        }

        jvmTest {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}
