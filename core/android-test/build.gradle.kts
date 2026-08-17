plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.tracker.android.junit5)
}

android {
    namespace = "com.tracker.core.android_test"
    compileSdk = 37

    defaultConfig {
        minSdk = 25
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    "debugImplementation"("androidx.compose.ui:ui-test-manifest:1.6.8")
    implementation(projects.auth.data)
    implementation(projects.core.domain)
    api(projects.core.test)
    implementation(libs.ktor.client.mock)
    implementation(libs.bundles.ktor)
    implementation(libs.coroutines.test)
}
