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
  implementation(libs.spring.boot.starter.actuator)
  implementation(libs.spring.boot.starter.data.jpa)
  implementation(libs.spring.boot.starter.web)
  implementation(libs.liquibase.core)
  implementation(libs.mapstruct)
  compileOnly(libs.lombok)
  developmentOnly(libs.spring.boot.devtools)
  runtimeOnly(libs.h2)
  annotationProcessor(libs.spring.boot.configuration.processor)
  annotationProcessor(libs.lombok)
  annotationProcessor(libs.mapstruct.processor)
  testImplementation(libs.spring.boot.starter.test)
  testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test> {
  useJUnitPlatform()
}
