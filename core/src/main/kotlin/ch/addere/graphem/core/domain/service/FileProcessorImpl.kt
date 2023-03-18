package ch.addere.graphem.core.domain.service

import ch.addere.graphem.core.domain.model.FileResult
import ch.addere.graphem.core.domain.model.LINE_BREAK
import ch.addere.graphem.core.domain.model.S
import ch.addere.graphem.core.domain.model.Symbol
import ch.addere.graphem.core.domain.model.SymbolCounter
import java.io.File
import java.nio.charset.Charset
import kotlin.streams.toList

class FileProcessorImpl : FileProcessor {

    override fun countGraphems(file: File, charset: Charset): FileResult {
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
        return FileResult(file.extension, symbolCounter)
    }
}
