import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.kotlin.multiplatform.library")
    id("com.vanniktech.maven.publish")
}

val libraryVersion: String = project.findProperty("VERSION_NAME")?.toString() ?: "1.0.0"

kotlin {
    applyDefaultHierarchyTemplate()

    androidLibrary {
        namespace = "dev.onexeor.uxcam"
        compileSdk = 36
        minSdk = 23

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    iosX64()
    iosArm64()
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
        commonMain.dependencies {
            implementation("io.github.aakira:napier:2.7.1")
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        androidMain.dependencies {
            implementation("com.uxcam:uxcam:3.8.8")
        }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}
