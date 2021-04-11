import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

apply {
    plugin("war")
}

plugins {
    kotlin("jvm") version "1.4.31"
    application
}

group = "jp.cordea"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
}

dependencies {
    testImplementation(kotlin("test-junit"))
    val ktorVersion = "1.5.1"
    implementation("io.ktor:ktor-server-servlet:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}
