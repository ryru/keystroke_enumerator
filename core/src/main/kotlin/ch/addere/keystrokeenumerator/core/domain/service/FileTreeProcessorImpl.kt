package ch.addere.keystrokeenumerator.core.domain.service

import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import ch.addere.keystrokeenumerator.core.domain.service.fileextension.FileExtensionService
import java.io.File
import java.nio.charset.Charset

class FileTreeProcessorImpl(private val fileProcessor: FileProcessor) : FileTreeProcessor {


    override fun countSymbolsWithinFileTree(fileTree: File, charset: Charset): List<FileResult> {
        return fileList(fileTree)
            .parallelStream()
            .map { processFile(it, charset) }
            .toList()
    }

    private fun fileList(fileTree: File): List<File> {
        val extensionService = FileExtensionService()
        return fileTree.walk()
            .filter { it.isFile }
            .filter { !filterTypicalGeneratedFolder(it) }
            .filter { extensionService.isSupportedFileExtension(it.extension) }
            .toList()
    }

    private fun filterTypicalGeneratedFolder(it: File) =
        it.path.contains("build/") ||
            it.path.contains("out/")

    private fun processFile(file: File, charset: Charset): FileResult {
        return fileProcessor.countSymbols(file, charset)
    }
}
