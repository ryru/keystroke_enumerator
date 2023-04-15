package ch.addere.keystrokeenumerator.app.domain.model.output

import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutResult
import kotlin.time.Duration

data class OutputData(
    val results: List<FileResult>,
    val duration: Duration,
    val totalSymbols: Int,
    val strokesPerLayouts: List<LayoutResult>
)
