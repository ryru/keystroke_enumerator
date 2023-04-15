package ch.addere.keystrokeenumerator.domain.service

import ch.addere.keystrokeenumerator.domain.model.FileResult
import java.io.File
import java.nio.charset.Charset

class FileTreeProcessorImpl : FileTreeProcessor {

    override fun countSymbolsWithinFileTree(fileTree: File, charset: Charset): List<FileResult> {
        return fileList(fileTree).parallelStream()
            .map { processFile(it, charset) }
            .toList()
    }

    private fun fileList(fileTree: File): List<File> {
        return fileTree.walk()
            .filter { it.isFile }
            .filter { !filterTypicalGeneratedFolder(it) }
            .filter { supportedFileExtensions(it) }
            .toList()
    }

    private fun filterTypicalGeneratedFolder(it: File) =
        it.path.contains("build/") ||
            it.path.contains("out/")

    private fun supportedFileExtensions(it: File) =
        it.extension == "bat" ||
            it.extension == "c" ||
            it.extension == "cpp" ||
            it.extension == "css" ||
            it.extension == "h" ||
            it.extension == "html" ||
            it.extension == "java" ||
            it.extension == "js" ||
            it.extension == "json" ||
            it.extension == "kt" ||
            it.extension == "kts" ||
            it.extension == "md" ||
            it.extension == "pl" ||
            it.extension == "sh" ||
            it.extension == "ts" ||
            it.extension == "txt" ||
            it.extension == "xml"

    private fun processFile(file: File, charset: Charset): FileResult {
        val countSymbols = FileProcessorImpl()
        return countSymbols.countSymbols(file, charset)
    }
}
