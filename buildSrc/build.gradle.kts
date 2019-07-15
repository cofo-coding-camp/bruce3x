import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
}


repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.kittinunf.fuel:fuel:2.1.0")
    implementation("com.github.kittinunf.fuel:fuel-json:2.1.0")
    implementation("com.github.kittinunf.fuel:fuel-gson:2.1.0")
    implementation("com.github.kittinunf.fuel:fuel-coroutines:2.1.0")
    implementation("org.jsoup:jsoup:1.12.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}