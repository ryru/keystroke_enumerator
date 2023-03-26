package domain.model

import domain.model.symbol.LINE_BREAK
import domain.model.symbol.SymbolCounter

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
