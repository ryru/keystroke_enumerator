package ch.addere.keystrokeenumerator.domain.service

import ch.addere.keystrokeenumerator.domain.model.FileResult
import ch.addere.keystrokeenumerator.domain.model.symbol.LINE_BREAK
import ch.addere.keystrokeenumerator.domain.model.symbol.Symbol
import ch.addere.keystrokeenumerator.domain.model.symbol.SymbolCounter
import ch.addere.keystrokeenumerator.domain.service.fileextension.FileExtensionService
import java.io.File
import java.nio.charset.Charset
import kotlin.streams.toList

class FileProcessorImpl(private val extensionService: FileExtensionService) : FileProcessor {

    override fun countSymbols(file: File, charset: Charset): FileResult {
        val symbolCounter = SymbolCounter()
        file.readLines(charset = charset)
            .flatMap { line ->
                symbolCounter.count(LINE_BREAK)
                line.codePoints().toList()
            }
            .map { Symbol(it) }
            .forEach { symbol -> symbolCounter.count(symbol) }
        val fileExt = extensionService.fileExtension(file.extension).orElseThrow()
        return FileResult(fileExt, file.length(), symbolCounter)
    }
}
