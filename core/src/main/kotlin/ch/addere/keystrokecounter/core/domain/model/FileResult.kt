package ch.addere.keystrokecounter.core.domain.model

import ch.addere.keystrokecounter.core.domain.model.symbol.LINE_BREAK
import ch.addere.keystrokecounter.core.domain.model.symbol.SymbolCounter

data class FileResult(
    val fileExtension: String,
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
