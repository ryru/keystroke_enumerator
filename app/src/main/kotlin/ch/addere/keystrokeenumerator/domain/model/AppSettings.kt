package ch.addere.keystrokeenumerator.domain.model

import domain.model.layout.LayoutFiles
import java.nio.file.Path

data class AppSettings(
    val path: Path?,
    val layouts: List<LayoutFiles>,
    val isPrintSupportedLayouts: Boolean
)
