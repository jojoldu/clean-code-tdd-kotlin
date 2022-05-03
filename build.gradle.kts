
plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest", "kotest-runner-junit5", "5.2.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.11"
    }
    ktlint {
        verbose.set(true)
    }
}
