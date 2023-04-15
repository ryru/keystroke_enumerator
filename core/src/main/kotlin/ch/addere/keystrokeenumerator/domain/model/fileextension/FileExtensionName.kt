package ch.addere.keystrokeenumerator.domain.model.fileextension

import ch.addere.keystrokeenumerator.domain.model.fileextension.FileExtensionType.*

enum class FileExtensionName(val extensionName: String, val extensionType: FileExtensionType) {
    ABAP("ABAP", PROGRAMMING),
    AGS_SCRIPT("AGS Script", PROGRAMMING),
    AMPL("AMPL", PROGRAMMING),
    ANTLR("ANTLR", PROGRAMMING),
    BATCH_FILE("Batchfile", PROGRAMMING),
    C("C", PROGRAMMING),
    CPP("C++", PROGRAMMING),
    CSS("css", MARKUP),
    GROFF("Groff", MARKUP),
    HTML("HTML", MARKUP),
    JAVA("Java", PROGRAMMING),
    JAVA_SCRIPT("JavaScript", PROGRAMMING),
    JSON("JSON", DATA),
    KOTLIN("Kotlin", DATA),
    MARKDOWN("Markdown", MARKUP),
    PERL("Perl", PROGRAMMING),
    PUBLIC_KEY("Public Key", DATA),
    TEXT("Text", DATA),
    XML("XML", MARKUP),
    SHELL("Shell", PROGRAMMING),
    TYPE_SCRIPT("TypeScript", PROGRAMMING),
}
