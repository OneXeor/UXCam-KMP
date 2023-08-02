pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://sdk.uxcam.com/android/")
    }
}

rootProject.name = "UXCam-KMP"
include(":uxcam-kmp-shared")
include(":UXCamExample:shared")
include(":UXCamExample:androidExample")
