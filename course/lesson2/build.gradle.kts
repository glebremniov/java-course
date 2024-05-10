plugins {
    id("java")
}

group = "com.andersenlab"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.bundles.mockito)
    testImplementation(libs.assertj.core)
}

tasks.test {
    useJUnitPlatform()
}
