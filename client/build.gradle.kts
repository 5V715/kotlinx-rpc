plugins {
    kotlin("jvm") version "1.9.24"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("plugin.serialization") version "1.9.23"
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
    implementation("com.github.ajalt.clikt:clikt:4.4.0")
    implementation("io.ktor:ktor-client-core:2.3.12")
    implementation("io.ktor:ktor-client-cio:2.3.12")
    implementation("org.jetbrains.kotlinx:kotlinx-rpc-krpc-ktor-client:0.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-rpc-krpc-client:0.2.1")
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
    implementation("org.slf4j:slf4j-simple:2.0.13")
    implementation("org.jetbrains.kotlinx:kotlinx-rpc-krpc-serialization-json:0.2.1")

}