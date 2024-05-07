plugins {
  id("java")
}

group = "org.andersenlab"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  implementation("com.h2database:h2:2.2.224")
}

tasks.test {
  useJUnitPlatform()
}
