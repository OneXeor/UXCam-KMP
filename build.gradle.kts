plugins {
    // trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.1.1").apply(false)
    kotlin("multiplatform").version("1.9.21").apply(false)
    id("com.vanniktech.maven.publish").version("0.30.0").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
