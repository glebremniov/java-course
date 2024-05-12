plugins {
  id("java")
}

group = "org.andersenlab"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  // https://mvnrepository.com/artifact/com.zaxxer/HikariCP
  implementation("com.zaxxer:HikariCP:5.1.0")
  implementation(libs.hibernate.core)
  implementation(libs.logback.classic)
  runtimeOnly(libs.h2)

  compileOnly(libs.lombok)
  annotationProcessor(libs.lombok)

  testImplementation(platform(libs.junit.bom))
  testImplementation(libs.junit.jupiter)

  testCompileOnly(libs.lombok)
  testAnnotationProcessor(libs.lombok)
}

tasks.test {
  useJUnitPlatform()
}
