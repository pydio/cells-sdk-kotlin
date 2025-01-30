plugins {
    kotlin("multiplatform") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
    id("maven-publish")
}

allprojects {
    version = "0.1.1-dev"
    group = "com.pydio.kotlin"
}


repositories {
    mavenLocal()
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

publishing {
    publications {
        // see https://docs.gradle.org/current/userguide/publishing_maven.html
        create<MavenPublication>("sdk-openapi-multiplatform") {
            pom {
                name = "com.pydio.kotlin.openapi.kmp"
                description = "Openapi generated Cells v2 SDK for Kotlin Multi Platform"
                url = "https://pydio.com"
//                properties = mapOf(
//                    "myProp" to "value",
//                    "prop.with.dots" to "anotherValue"
//                )
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "cdujeu"
                        name = "Charles du Jeu"
                        email = "charles@pydio.com"
                    }
                    developer {
                        id = "bsinou"
                        name = "Bruno Sinou"
                        email = "bruno.sinou@wire.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/pydio/cells-sdk-kotlin.git"
                    developerConnection = "scm:git:ssh://github.com/pydio/cells-sdk-kotlin.git"
                    url = "https://pydio.com/"
                }
            }
        }
    }
}
