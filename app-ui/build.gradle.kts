plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    jvmToolchain(17)

    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
        }
        commonMain.dependencies {
            implementation(projects.common.resources)
            implementation(projects.common.domain)

            api(compose.ui)
            api(compose.foundation)
            api(compose.material3)
            api(compose.runtime)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.jetbrains.navigation.compose)
            api(libs.serialization)
        }
        iosMain.dependencies {

        }
    }
}

android {
    namespace = "dev.partemy.zmeuai.app.ui"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}