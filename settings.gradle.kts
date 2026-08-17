pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    //id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "trackrun"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":auth:presentation")
include(":core:presentation:designsystem")
include(":auth:domain")
include(":auth:data")
include(":core:presentation:ui")
include(":core:domain")
include(":core:data")
include(":run:presentation")
include(":core:test")
include(":core:android-test")
