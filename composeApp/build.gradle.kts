import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinKsp)
    alias(libs.plugins.realm)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.room)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }


    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            api(libs.koin.android)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.kotlin.coroutines)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(projects.shared)
            implementation(libs.ktor.client.core)
            api(libs.compose.image.loader)
            implementation(libs.ktor.json.serialization)
            implementation(libs.ktor.content.negotiation)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.client.cio)
            implementation(libs.kotlin.serialization)
            implementation(libs.realm.library.base)
            api(libs.koin.core)
            api(libs.calf)
            api(libs.moko.geo)
            api(libs.moko.biometry)
            implementation(libs.koin.annotations)
            implementation(libs.moko.mvvm)
            implementation(libs.koin.compose)
            implementation(libs.bundles.voyager)
            implementation(libs.kotlin.coroutines)
            implementation(libs.kotlinx.datetime)
            implementation(libs.paging.compose)
            implementation(libs.paging.common)
            implementation(libs.compose.materialIcons)
            implementation(libs.room.runtime)
            implementation(libs.sqlite.bundled)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.drawin)
        }
    }
}

android {
    namespace = "com.tiqaro.tiqarobooking"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.tiqaro.tiqarobooking"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    implementation(libs.moko.geo)
    implementation(libs.moko.geo.compose)
    implementation(libs.moko.biometry)
    implementation(libs.moko.biometry.compose)
    ksp(libs.room.compiler)
    commonMainImplementation(libs.calendar.compose.basis)
    commonMainImplementation(libs.calendar.compose.ranges) // includes basis
    commonMainImplementation(libs.calendar.compose.pager) // includes basis
    commonMainImplementation(libs.calendar.compose.datepicker) // includes pager + ranges
}


