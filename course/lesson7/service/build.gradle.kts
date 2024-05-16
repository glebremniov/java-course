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
  implementation("org.springframework.boot:spring-boot-starter")
  compileOnly(libs.lombok)
  annotationProcessor(libs.spring.boot.configuration.processor)
  annotationProcessor(libs.lombok)
  testImplementation(libs.spring.boot.starter.test)
  testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.bootJar {
  enabled = false
}

tasks.jar {
  enabled = true
}
