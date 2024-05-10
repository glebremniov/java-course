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
  implementation(libs.bundles.log4j)
  runtimeOnly(libs.h2)
}

tasks.test {
  useJUnitPlatform()
}
