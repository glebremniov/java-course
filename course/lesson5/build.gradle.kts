plugins {
  id("java")
}

group = "org.andersenlab"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.h2)
}

tasks.test {
  useJUnitPlatform()
}
