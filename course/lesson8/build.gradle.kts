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
  implementation(libs.spring.boot.starter.data.jpa)
  implementation(libs.spring.boot.starter.security)
  compileOnly(libs.lombok)
  developmentOnly(libs.spring.boot.devtools)
  developmentOnly(libs.spring.boot.docker.compose)
  runtimeOnly(libs.postgresql)
  annotationProcessor(libs.spring.boot.configuration.processor)
  annotationProcessor(libs.lombok)
  testImplementation(libs.spring.boot.starter.test)
  testImplementation(libs.spring.boot.security.test)
  testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test> {
  useJUnitPlatform()
}
