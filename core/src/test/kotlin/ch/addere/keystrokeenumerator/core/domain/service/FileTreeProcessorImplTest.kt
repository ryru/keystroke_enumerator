package ch.addere.keystrokeenumerator.core.domain.service

import ch.addere.keystrokeenumerator.core.domain.service.fileextension.FileExtensionService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.text.Charsets.UTF_8

class FileTreeProcessorImplTest {

    @Test
    fun testReadTestResourceTree() {
        val fileTreeProcessor = FileTreeProcessorImpl(FileProcessorImpl(FileExtensionService()))

        val fileTree = File("src/test/resources/fileTree/")
        val results = fileTreeProcessor.countSymbolsWithinFileTree(fileTree, UTF_8)

        assertThat(results.map { it.fileExtension.extension }.toList()).containsExactlyInAnyOrder(
            "c",
            "html",
            "java",
            "md",
            "txt",
        )
        assertThat(results.sumOf { it.fileSize }).isEqualTo(25)
        assertThat(results.sumOf { it.symbolCounter.getSymbolCounts().values.sum() }).isEqualTo(25)
    }
}
