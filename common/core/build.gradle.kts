plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        androidMain.dependencies {
            api(libs.koin.android)
            api(libs.koin.androidx.compose)
        }
        commonMain.dependencies {
            implementation(projects.appUi)
            implementation(projects.common.domain)

            api(libs.koin.core)
            api(libs.koin.compose)
        }
        iosMain.dependencies {

        }
    }
}

android {
    namespace = "dev.partemy.zmeuai.common.core"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}