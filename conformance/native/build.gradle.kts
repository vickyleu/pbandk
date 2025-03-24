import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

kotlin {
    linuxX64()
    macosArm64()
    macosX64()
    mingwX64("windows")
    linuxArm32Hfp()
    linuxArm64()

    targets.withType<KotlinNativeTarget> {
        binaries {
            executable("conformance")
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                api(project(":conformance:conformance-lib"))
            }
        }
    }
}