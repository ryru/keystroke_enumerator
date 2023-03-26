package ch.addere.keystrokeenumerator.core.domain.service

import domain.service.FileTreeProcessorImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class FileTreeProcessorImplTest {

    @Test
    fun testReadTestResourceTree() {
        val fileTreeProcessor = FileTreeProcessorImpl()

        val fileTree = File("src/test/resources/fileTree/")
        val results = fileTreeProcessor.countSymbolsWithinFileTree(fileTree, Charsets.UTF_8)

        assertThat(results.map { it.fileExtension }.toList()).containsExactlyInAnyOrder(
            "c",
            "html",
            "java",
            "txt",
            "md"
        )
        assertThat(results.sumOf { it.fileSize }).isEqualTo(25)
        assertThat(results.sumOf { it.symbolCounter.getSymbolCounts().values.sum() }).isEqualTo(25)
    }
}
