plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "ch.addere.keystrokeenumerator"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
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

application {
    mainClass.set("ch.addere.keystrokeenumerator.application.KeystrokeEnumeratorKt")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "ch.addere.keystrokeenumerator.application.KeystrokeEnumeratorKt"
    }

    // To avoid the duplicate handling strategy error
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // To add all the dependencies
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}
