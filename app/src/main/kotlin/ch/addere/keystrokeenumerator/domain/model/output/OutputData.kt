package ch.addere.keystrokeenumerator.domain.model.output

import domain.model.FileResult
import domain.model.layout.LayoutResult
import kotlin.time.Duration

data class OutputData(
    val results: List<FileResult>,
    val duration: Duration,
    val totalSymbols: Int,
    val strokesPerLayouts: List<LayoutResult>
)
