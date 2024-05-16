plugins {
    java
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

group = "org.andersenlab"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":lesson7:api"))
    implementation(project(":lesson7:service"))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.mapstruct)
    compileOnly(libs.lombok)
    developmentOnly(libs.spring.boot.devtools)
    annotationProcessor(libs.spring.boot.configuration.processor)
    annotationProcessor(libs.lombok)
    annotationProcessor(libs.mapstruct.processor)
    testImplementation(libs.spring.boot.starter.test)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
