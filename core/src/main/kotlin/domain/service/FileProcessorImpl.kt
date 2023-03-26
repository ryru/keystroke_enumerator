package domain.service

import domain.model.FileResult
import domain.model.symbol.LINE_BREAK
import domain.model.symbol.Symbol
import domain.model.symbol.SymbolCounter
import java.io.File
import java.nio.charset.Charset
import kotlin.streams.toList

class FileProcessorImpl : FileProcessor {

    override fun countSymbols(file: File, charset: Charset): FileResult {
        val symbolCounter = SymbolCounter()
        file.readLines(charset = charset)
            .flatMap { line ->
                symbolCounter.count(LINE_BREAK)
                line.codePoints().toList()
            }
            .map { Symbol(it) }
            .forEach { symbol ->
                symbolCounter.count(symbol)
            }
        return FileResult(file.extension, file.length(), symbolCounter)
    }
}