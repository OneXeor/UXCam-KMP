import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.vanniktech.maven.publish")
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
        publishLibraryVariants("release")
    }

    ios()
    iosSimulatorArm64()
    cocoapods {
        version = libraryVersion
        ios.deploymentTarget = "12.0"
        framework {
            baseName = "uxcam-kmp-shared"
            isStatic = true
        }
        pod("UXCam")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.github.aakira:napier:2.7.1")
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
    namespace = "dev.onexeor.uxcam"
    compileSdk = 33
    defaultConfig {
        minSdk = 23
    }

    dependencies {
        implementation("com.uxcam:uxcam:3.6.12")
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}
