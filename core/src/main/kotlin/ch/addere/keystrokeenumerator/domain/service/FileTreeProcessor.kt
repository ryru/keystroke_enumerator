package ch.addere.keystrokeenumerator.domain.service

import ch.addere.keystrokeenumerator.domain.model.FileResult
import java.io.File
import java.nio.charset.Charset

interface FileTreeProcessor {

    /**
     * Traverse file tree and count symbols in files.
     */
    fun countSymbolsWithinFileTree(fileTree: File, charset: Charset): List<FileResult>
}
