plugins {
    // trick: for the same plugin versions in all sub-modules
    id("com.android.kotlin.multiplatform.library").version("8.13.2").apply(false)
    id("com.android.application").version("8.13.2").apply(false)
    kotlin("multiplatform").version("2.3.0").apply(false)
    kotlin("android").version("2.3.0").apply(false)
    kotlin("native.cocoapods").version("2.3.0").apply(false)
    id("org.jetbrains.kotlin.plugin.compose").version("2.3.0").apply(false)
    id("com.vanniktech.maven.publish").version("0.30.0").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
