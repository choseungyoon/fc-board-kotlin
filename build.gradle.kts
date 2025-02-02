plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "1.9.25"
    id("org.jlleitschuh.gradle.ktlint") version "11.4.0"
    kotlin("kapt") version "1.8.22"
}

group = "com.fastcampus"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Kotest framework for writing tests
    testImplementation("io.kotest:kotest-runner-junit5:5.7.2") // Core runner for Kotest tests

    // Kotest assertions core library
    testImplementation("io.kotest:kotest-assertions-core:5.7.2")

    // Kotest Spring extensions for Spring Boot tests
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.3")

    // Springdoc OpenAPI for Swagger integration
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

    // Additional dependency for Kotlin support (optional but recommended)
    implementation("org.springdoc:springdoc-openapi-starter-common:2.2.0")

    // QueryDSL dependencies
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta") // Annotation processor for QueryDSL
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
