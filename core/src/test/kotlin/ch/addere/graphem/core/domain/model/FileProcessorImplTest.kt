package ch.addere.graphem.core.domain.model

import org.junit.jupiter.api.Test
import java.nio.file.Path
import kotlin.io.path.createTempFile
import kotlin.io.path.writeLines
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.text.Charsets.UTF_8

class FileProcessorImplTest {

    @Test
    fun testReadFile() {
        val tmpFile = tempFileWithMultipleLines(
            """
                        a
                        bb
                        ccc
                        dddd
                    """
        )
        val fileProcessor = FileProcessorImpl()

        val result = fileProcessor.countGraphems(tmpFile.toFile(), UTF_8)

        assertEquals(4, result.totalLineBreaks)
        assertEquals(10, result.totalProcessedGraphems)
        assertEquals(1, result.graphemsMap['a'])
        assertEquals(2, result.graphemsMap['b'])
        assertEquals(3, result.graphemsMap['c'])
        assertEquals(4, result.graphemsMap['d'])
        assertNull(result.graphemsMap['A'])
        assertNull(result.graphemsMap['B'])
        assertNull(result.graphemsMap['C'])
        assertNull(result.graphemsMap['D'])
        assertNull(result.graphemsMap['E'])
    }

    private fun tempFileWithMultipleLines(s: String): Path {
        val tmpFile = createTempFile("test")
        tmpFile.writeLines(s.trimIndent().lineSequence())
        return tmpFile
    }
}
