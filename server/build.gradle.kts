plugins {
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
    application
}

group = "dev.silas"
version = "0.0.1"

repositories {
    mavenCentral()
}

application {
    mainClass.set("dev.silas.ApplicationKt")
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(libs.bundles.server)
}
