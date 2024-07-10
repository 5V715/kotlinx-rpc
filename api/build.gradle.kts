plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.23"
    id("org.jetbrains.kotlinx.rpc.plugin") version "0.2.1"
    id("com.google.devtools.ksp") version "1.9.24-1.0.20"
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    api("org.jetbrains.kotlinx:kotlinx-rpc-core:0.2.1")
    api("org.jetbrains.kotlinx:kotlinx-serialization-core:1.6.3")
}
