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
    implementation("com.github.kittinunf.fuel:fuel:2.2.0")
    implementation("com.github.kittinunf.fuel:fuel-json:2.2.0")
    implementation("com.github.kittinunf.fuel:fuel-gson:2.2.0")
    implementation("com.github.kittinunf.fuel:fuel-coroutines:2.2.0")
    implementation("org.jsoup:jsoup:1.12.1")
    implementation("org.json:json:20190722")
    implementation("com.google.code.gson:gson:2.8.5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}