plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.kotlin.rpc)

}

repositories {
    mavenCentral()
}

dependencies {
    api(libs.bundles.core)
}
