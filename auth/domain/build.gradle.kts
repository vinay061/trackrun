plugins {
    //alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.tracker.jvm.library)
    alias(libs.plugins.tracker.jvm.junit5)
}

dependencies {
    implementation(projects.core.domain)
    //testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
