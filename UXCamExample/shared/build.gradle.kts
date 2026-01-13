import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.kotlin.multiplatform.library")
}

val libraryVersion: String = project.findProperty("VERSION_NAME")?.toString() ?: "1.0.0"

kotlin {
    applyDefaultHierarchyTemplate()

    androidLibrary {
        namespace = "dev.onexeor.uxcam.uxcamexample"
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
        commonMain.dependencies {
            implementation(project(":uxcam-kmp-shared"))
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
