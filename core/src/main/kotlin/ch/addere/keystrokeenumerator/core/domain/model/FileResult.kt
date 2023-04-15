package ch.addere.keystrokeenumerator.core.domain.model

import ch.addere.keystrokeenumerator.core.domain.model.fileextension.FileExtension
import ch.addere.keystrokeenumerator.core.domain.model.symbol.LINE_BREAK
import ch.addere.keystrokeenumerator.core.domain.model.symbol.SymbolCounter

data class FileResult(
    val fileExtension: FileExtension,
    val fileSize: Long,
    val symbolCounter: SymbolCounter
) {

    fun totalSymbolsProcessed(): Int {
        return symbolCounter.totalSymbolsProcessed()
    }

    fun totalLineBreaks(): Int {
        return symbolCounter.getSymbolCount(LINE_BREAK)
    }
}
