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
            api(libs.koin.android)
            api(libs.koin.androidx.compose)
        }
        commonMain.dependencies {
            implementation(projects.appUi)
            implementation(projects.common.domain)
            implementation(projects.common.data)
            implementation(projects.common.database)

            implementation(libs.room.runtime)  //TODO remove

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