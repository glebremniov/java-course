plugins {
  id("war")
}

group = "org.andersenlab"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  // https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
  compileOnly(libs.servlet.api)
}
