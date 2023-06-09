@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

group = "ch.addere.keystrokeenumerator"
version = File("$projectDir/../version.txt").readText()

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))

    implementation(libs.clikt)
    implementation(libs.koin)

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
    mainClass.set("ch.addere.keystrokeenumerator.app.application.KeystrokeEnumeratorKt")
}

tasks.withType<Jar> {
    archiveFileName.set("ke.jar")

    manifest {
        attributes["Main-Class"] = "ch.addere.keystrokeenumerator.app.application.KeystrokeEnumeratorKt"
    }

    // add version.txt into jar
    from(layout.projectDirectory.file("../version.txt"))

    // To avoid the duplicate handling strategy error
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // To add all the dependencies
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

distributions {
    main {
        distributionBaseName.set("ke")
    }
}

tasks.withType<CreateStartScripts> {
    applicationName = "ke"
}
