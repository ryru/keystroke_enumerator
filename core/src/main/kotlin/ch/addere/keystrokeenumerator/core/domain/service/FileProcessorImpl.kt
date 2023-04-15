package ch.addere.keystrokeenumerator.core.domain.service

import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import ch.addere.keystrokeenumerator.core.domain.model.fileextension.FileExtension
import ch.addere.keystrokeenumerator.core.domain.model.symbol.LINE_BREAK
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Symbol
import ch.addere.keystrokeenumerator.core.domain.model.symbol.SymbolCounter
import java.io.File
import java.nio.charset.Charset
import kotlin.streams.toList

class FileProcessorImpl : FileProcessor {

    override fun countSymbols(file: File, extension: FileExtension, charset: Charset): FileResult {
        val symbolCounter = SymbolCounter()
        file.readLines(charset = charset)
            .flatMap { line ->
                symbolCounter.count(LINE_BREAK)
                line.codePoints().toList()
            }
            .map { Symbol(it) }
            .forEach { symbol -> symbolCounter.count(symbol) }
        return FileResult(extension, file.length(), symbolCounter)
    }
}
