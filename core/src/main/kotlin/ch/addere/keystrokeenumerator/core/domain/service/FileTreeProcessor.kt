package ch.addere.keystrokeenumerator.core.domain.service

import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import java.io.File
import java.nio.charset.Charset

interface FileTreeProcessor {

    /**
     * Traverse file tree and count symbols in files.
     */
    fun countSymbolsWithinFileTree(fileTree: File, charset: Charset): List<FileResult>
}
