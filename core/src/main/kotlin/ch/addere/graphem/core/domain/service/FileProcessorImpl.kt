package ch.addere.graphem.core.domain.service

import ch.addere.graphem.core.domain.model.FileResult
import ch.addere.graphem.core.domain.model.LINE_BREAK
import ch.addere.graphem.core.domain.model.Symbol
import ch.addere.graphem.core.domain.model.SymbolCounter
import java.io.File
import java.nio.charset.Charset

class FileProcessorImpl : FileProcessor {

    override fun countGraphems(file: File, charset: Charset): FileResult {
        val symbolCounter = SymbolCounter()
        file.forEachLine(charset = charset) { line ->
            line.map { it.code }
                .map { Symbol(it) }
                .forEach { symbolCounter.count(it) }
            symbolCounter.count(LINE_BREAK)
        }
        return FileResult(file.extension, symbolCounter)
    }
}
