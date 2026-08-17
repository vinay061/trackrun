import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.`kotlin-dsl`

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    `kotlin-dsl`
}

group = "com.project.tracker.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "tracker.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "tracker.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplicationWearCompose") {
            id = "tracker.android.application.wear.compose"
            implementationClass = "AndroidApplicationWearComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "tracker.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("jvmJunit5") {
            id = "tracker.jvm.junit5"
            implementationClass = "JvmJUnit5ConventionPlugin"
        }
        register("jvmLibrary") {
            id = "tracker.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("androidJunit5") {
            id = "tracker.android.junit5"
            implementationClass = "AndroidJUnit5ConventionPlugin"
        }
    }
}
