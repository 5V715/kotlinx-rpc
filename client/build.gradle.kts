plugins {
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.shadow.jar)
    application
}

repositories {
    mavenCentral()
}

application {
    mainClass = "App"
}

dependencies {
    implementation(project(":api"))
    implementation(libs.bundles.client)

}