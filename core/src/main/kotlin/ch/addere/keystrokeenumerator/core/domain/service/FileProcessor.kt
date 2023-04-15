package ch.addere.keystrokeenumerator.core.domain.service

import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import ch.addere.keystrokeenumerator.core.domain.model.fileextension.FileExtension
import java.io.File
import java.nio.charset.Charset

interface FileProcessor {

    /**
     * Count symbols within file.
     */
    fun countSymbols(file: File, extension: FileExtension, charset: Charset): FileResult
}
