plugins {
  id("java")
  id("war")
}

group = "org.andersenlab"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  // https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
  compileOnly("javax.servlet:javax.servlet-api:4.0.1")
}
