plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

val libraryVersion: String = project.findProperty("VERSION_NAME")?.toString() ?: "1.0.0"

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "UXCam for KMP example"
        homepage = "onexeor.dev"
        version = libraryVersion
        ios.deploymentTarget = "12.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":uxcam-kmp-shared"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "dev.onexeor.uxcam.uxcamexample"
    compileSdk = 33
    defaultConfig {
        minSdk = 23
    }
}
