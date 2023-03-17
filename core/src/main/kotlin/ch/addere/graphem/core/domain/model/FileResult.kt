package ch.addere.graphem.core.domain.model

data class FileResult(
    val graphemsMap: Map<Char, Int>,
    val totalLineBreaks: Int,
    val totalProcessedGraphems: Int
)
