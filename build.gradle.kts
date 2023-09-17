plugins {
    kotlin("multiplatform") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    id("maven-publish")
}

group = "com.vcifello.kotwordfetcher"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(8)
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    js(IR) {
        browser {}
        binaries.executable()
    }


    
    sourceSets {
        val ktorVersion = "2.3.4"
        val serialization_version = "1.6.0"
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation ("com.jeffpdavidson.kotwords:kotwords:1.3.6")
                implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_version")
                implementation("com.soywiz.korlibs.klock:klock:3.4.0")
                implementation("org.jsoup:jsoup:1.15.3")
                implementation("org.apache.pdfbox:pdfbox:2.0.27")
                implementation("com.squareup.okio:okio:3.3.0")
                implementation("com.github.ajalt.colormath:colormath:3.2.1")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
                implementation("ch.qos.logback:logback-classic:1.4.7")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core-jvm:$ktorVersion")
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
            }
        }
        val jvmTest by getting
        val jsMain by getting
//        val jsTest by getting {
//            getByName("kotwordfetcher") {
//            dependencies {
//                implementation(kotlin("script-runtime"))
//            }
//        }
//        }
    }
}
