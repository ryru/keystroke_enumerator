package ch.addere.keystrokeenumerator.app.domain.model

import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutFiles
import java.nio.file.Path

data class AppSettings(
    val path: Path?,
    val layouts: List<LayoutFiles>,
    val isPrintSupportedLayouts: Boolean,
    val isPrintSupportedFileTypes: Boolean,
)
