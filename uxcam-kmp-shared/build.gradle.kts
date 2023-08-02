plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

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

    ios()
    iosSimulatorArm64()
    cocoapods {
        version = "1.0"
        ios.deploymentTarget = "12.0"
        framework {
            baseName = "uxcam-kmp-shared"
            isStatic = true
        }
        pod("UXCam")
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "dev.onexeor.uxcam"
    compileSdk = 33
    defaultConfig {
        minSdk = 23
    }

    dependencies {
        implementation("com.uxcam:uxcam:3.6.12")
    }
}
