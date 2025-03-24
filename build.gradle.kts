import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import java.net.URL

// Top-level build configuration

plugins {
    kotlin("multiplatform") version Versions.kotlin apply false
    id("com.android.library") version Versions.androidGradlePlugin apply false
    id("org.springframework.boot") version Versions.springBootGradlePlugin apply false
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version Versions.binaryCompatibilityValidatorGradlePlugin apply false

    id("com.google.osdetector") version Versions.osDetectorGradlePlugin
}

val sonatypeApiUser = providers.gradlePropertyOrEnvironmentVariable("sonatypeApiUser")
val sonatypeApiKey = providers.gradlePropertyOrEnvironmentVariable("sonatypeApiKey")
val sonatypeRepositoryId = providers.gradlePropertyOrEnvironmentVariable("sonatypeRepositoryId")
val publishToSonatype = sonatypeApiUser.isPresent && sonatypeApiKey.isPresent
if (!publishToSonatype) {
    logger.info("Sonatype API key not defined, skipping configuration of Maven Central publishing repository")
}

//val signingKeyAsciiArmored = providers.gradlePropertyOrEnvironmentVariable("signingKeyAsciiArmored")
//if (signingKeyAsciiArmored.isPresent) {
//    subprojects {
//        plugins.withType<SigningPlugin> {
//            configure<SigningExtension> {
//                @Suppress("UnstableApiUsage")
//                useInMemoryPgpKeys(signingKeyAsciiArmored.get(), "")
//                sign(extensions.getByType<PublishingExtension>().publications)
//            }
//        }
//    }
//} else {
//    logger.info("PGP signing key not defined, skipping signing configuration")
//}

val downloadProtoc by configurations.creating {
    isTransitive = false
}

val wellKnownTypes by configurations.creating {
    isTransitive = false
}

dependencies {
    downloadProtoc(
        group = "com.google.protobuf",
        name = "protoc",
        version = Versions.protoc,
        classifier = osdetector.classifier,
        ext = "exe"
    )
    wellKnownTypes("com.google.protobuf:protobuf-java:${Versions.protobufJava}")
}

val extractWellKnownTypeProtos by tasks.registering(Sync::class) {
    dependsOn(wellKnownTypes)
    from({
        wellKnownTypes.filter { it.extension == "jar" }.map { zipTree(it) }
    })
    include("**/*.proto")
    includeEmptyDirs = false
    into(layout.buildDirectory.dir("bundled-protos"))
}

allprojects {
    repositories {
        mavenCentral{
            content {
                excludeGroupByRegex("com.vickyleu.kotlinx*")
                excludeGroupByRegex("com.vickyleu.ktor*")
                excludeGroupByRegex("com.vickyleu.oshai*")
            }
        }
        maven {
            url = uri("https://raw.githubusercontent.com/vickyleu/kotlin_linuxarm32hfp_maven/main")
            content{
                includeGroup("com.vickyleu.kotlinx.coroutines")
                includeGroup("com.vickyleu.kotlinx")
                includeGroup("com.vickyleu.ktor")
                includeGroup("com.vickyleu.oshai")
            }
        }
    }

    tasks.withType<AbstractTestTask> {
        testLogging {
            outputs.upToDateWhen { false }
            showStandardStreams = true
            exceptionFormat = TestExceptionFormat.FULL
            events = setOf(
                TestLogEvent.PASSED,
                TestLogEvent.SKIPPED,
                TestLogEvent.FAILED
            )
        }
    }

//    if (publishToSonatype) {
//
//    }
    plugins.withType<MavenPublishPlugin>() {
        configure<PublishingExtension> {
            repositories {
                maven("file://${rootProject.rootDir.absolutePath}/maven")
//                    maven {
//                        name = "sonatype"
//                        url = when {
//                            project.version.toString().endsWith("-SNAPSHOT") ->
//                                uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
//                            !sonatypeRepositoryId.isPresent ->
//                                throw IllegalStateException("Sonatype Repository ID must be provided for non-SNAPSHOT builds")
//                            else ->
//                                uri("https://s01.oss.sonatype.org/service/local/staging/deployByRepositoryId/${sonatypeRepositoryId.get()}")
//                        }
//
//                        credentials {
//                            username = sonatypeApiUser.get()
//                            password = sonatypeApiKey.get()
//                        }
//                    }
            }
        }
    }

    this.configurations.all {
        // 所有group是org.jetbrains.kotlinx并且module包含coroutines的都替换成com.vickyleu.kotlinx.coroutines:原来的module:版本号
        resolutionStrategy.eachDependency {
            if (requested.group == "org.jetbrains.kotlinx" && requested.module.name.startsWith("kotlinx-coroutines")){
                this.useTarget("com.vickyleu.kotlinx.coroutines:${requested.module.name}:1.10.1-SNAPSHOT")
            }else if (requested.group == "org.jetbrains.kotlinx" && requested.module.name.startsWith("kotlinx-html")){
                this.useTarget("com.vickyleu.kotlinx:${requested.module.name}:0.12.0")
            }else if (requested.group == "org.jetbrains.kotlinx" && (
                        requested.module.name.startsWith("kotlinx-rpc")&&
                                requested.module.name!="kotlinx-rpc-bom"
                        )
            ){
                this.useTarget("com.vickyleu.kotlinx:${requested.module.name}:0.5.1")
            }else if (requested.group == "io.ktor" && requested.module.name.startsWith("ktor")){
                this.useTarget("com.vickyleu.ktor:${requested.module.name}:3.1.2-SNAPSHOT")
            }else if (requested.group == "io.github.oshai"){
                this.useTarget("com.vickyleu.oshai:${requested.module.name}:7.0.6")
            }
        }
    }
}
