package ch.addere.graphem.core.domain.model

data class FileResult(
    val fileExtension: String,
    val graphemsMap: Map<Int, Int>,
    val totalLineBreaks: Int,
    val totalProcessedGraphems: Int
)
