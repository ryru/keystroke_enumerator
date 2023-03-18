package ch.addere.graphem.core.domain.model

data class FileResult(
    val fileExtension: String,
    val symbolCounter: SymbolCounter
) {

    fun totalSymbolsProcessed(): Int {
        return symbolCounter.totalSymbolsProcessed()
    }

    fun totalLineBreaks(): Int {
        return symbolCounter.getSymbolCount(LINE_BREAK)
    }
}
