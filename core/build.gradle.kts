plugins {
    jacoco
    kotlin("jvm") version "1.8.0"
}

group = "ch.addere"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(libs.commons.csv)

    testImplementation(libs.assertj.core)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(19))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

tasks.named("check") {
    dependsOn("jacocoTestCoverageVerification")
}

tasks.named("jacocoTestReport") {
    dependsOn(testing.suites.named("test"))
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.8".toBigDecimal()
            }
        }
    }
}
