plugins {
  id("java")
}

group = "org.andersenlab"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.hibernate.core)
  implementation(libs.logback.classic)
  runtimeOnly(libs.h2)

  compileOnly(libs.lombok)
  annotationProcessor(libs.lombok)

  testCompileOnly(libs.lombok)
  testAnnotationProcessor(libs.lombok)
}

tasks.test {
  useJUnitPlatform()
}
