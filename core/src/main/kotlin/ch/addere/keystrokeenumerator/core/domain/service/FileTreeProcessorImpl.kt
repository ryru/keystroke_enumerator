package ch.addere.keystrokeenumerator.core.domain.service

import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import ch.addere.keystrokeenumerator.core.domain.model.fileextension.FileExtension
import ch.addere.keystrokeenumerator.core.domain.service.fileextension.FileExtensionService
import java.io.File
import java.nio.charset.Charset

class FileTreeProcessorImpl(
    private val extensionService: FileExtensionService,
    private val fileProcessor: FileProcessor
) : FileTreeProcessor {


    override fun countSymbolsWithinFileTree(fileTree: File, charset: Charset): List<FileResult> {
        return fileList(fileTree)
            .parallelStream()
            .map { processFile(it.first, it.second, charset) }
            .toList()
    }

    private fun fileList(fileTree: File): List<Pair<File, FileExtension>> {
        return fileTree.walk()
            .filter { it.isFile }
            .filter { !filterTypicalGeneratedFolder(it) }
            .map { file -> Pair(file, extensionService.fileExtension(file.extension)) }
            .filter { it.second.isPresent }
            .map { Pair(it.first, it.second.get()) }
            .toList()
    }

    private fun filterTypicalGeneratedFolder(it: File) =
        it.path.contains("build/") ||
            it.path.contains("out/")

    private fun processFile(file: File, extension: FileExtension, charset: Charset): FileResult {
        return fileProcessor.countSymbols(file, extension, charset)
    }
}
