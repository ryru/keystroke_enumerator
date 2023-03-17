package ch.addere.graphem.core.domain.model

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.text.Charsets.ISO_8859_1
import kotlin.text.Charsets.UTF_16
import kotlin.text.Charsets.UTF_8

class FileProcessorImplTest {

    @Test
    fun testReadCFileWithSpaceInUtf8() {
        val fileProcessor = FileProcessorImpl()

        val cFile = File("src/test/resources/ch/addere/graphem/core/domain/model/main_whitespace_utf8.c")
        val result = fileProcessor.countGraphems(cFile, UTF_8)

        assertEquals(89, result.totalProcessedGraphems)
        assertContent(result)
    }

    @Test
    fun testReadCFileWithTabInUtf8() {
        val fileProcessor = FileProcessorImpl()

        val cFile = File("src/test/resources/ch/addere/graphem/core/domain/model/main_tab_utf8.c")
        val result = fileProcessor.countGraphems(cFile, UTF_8)

        assertEquals(83, result.totalProcessedGraphems)
        assertContent(result)
    }

    @Test
    fun testReadCFileWithSpaceInUtf16() {
        val fileProcessor = FileProcessorImpl()

        val cFile = File("src/test/resources/ch/addere/graphem/core/domain/model/main_whitespace_utf16.c")
        val result = fileProcessor.countGraphems(cFile, UTF_16)

        assertEquals(89, result.totalProcessedGraphems)
        assertContent(result)
    }

    @Test
    fun testReadCFileWithTabInUtf16() {
        val fileProcessor = FileProcessorImpl()

        val cFile = File("src/test/resources/ch/addere/graphem/core/domain/model/main_tab_utf16.c")
        val result = fileProcessor.countGraphems(cFile, UTF_16)

        assertEquals(83, result.totalProcessedGraphems)
        assertContent(result)
    }

    @Test
    fun testReadCFileWithSpaceInWesternIso_8859_1() {
        val fileProcessor = FileProcessorImpl()

        val cFile = File("src/test/resources/ch/addere/graphem/core/domain/model/main_whitespace_western.c")
        val result = fileProcessor.countGraphems(cFile, ISO_8859_1)

        assertEquals(89, result.totalProcessedGraphems)
        assertContent(result)
    }

    @Test
    fun testReadCFileWithTabInWesternIso_8859_1() {
        val fileProcessor = FileProcessorImpl()

        val cFile = File("src/test/resources/ch/addere/graphem/core/domain/model/main_tab_western.c")
        val result = fileProcessor.countGraphems(cFile, ISO_8859_1)

        assertEquals(83, result.totalProcessedGraphems)
        assertContent(result)
    }

    private fun assertContent(result: FileResult) {
        assertEquals("c", result.fileExtension)
        assertEquals(7, result.totalLineBreaks)
        assertEquals(3, result.graphemsMap['a'.code])
        assertEquals(2, result.graphemsMap['c'.code])
        assertEquals(3, result.graphemsMap['d'.code])
        assertEquals(3, result.graphemsMap['e'.code])
        assertEquals(1, result.graphemsMap['f'.code])
        assertEquals(1, result.graphemsMap['g'.code])
        assertEquals(2, result.graphemsMap['h'.code])
        assertEquals(1, result.graphemsMap['H'.code])
        assertEquals(5, result.graphemsMap['i'.code])
        assertEquals(4, result.graphemsMap['l'.code])
        assertEquals(1, result.graphemsMap['m'.code])
        assertEquals(5, result.graphemsMap['n'.code])
        assertEquals(3, result.graphemsMap['o'.code])
        assertEquals(1, result.graphemsMap['p'.code])
        assertEquals(6, result.graphemsMap['r'.code])
        assertEquals(2, result.graphemsMap['s'.code])
        assertEquals(4, result.graphemsMap['t'.code])
        assertEquals(2, result.graphemsMap['u'.code])
        assertEquals(1, result.graphemsMap['W'.code])
        assertEquals(1, result.graphemsMap['#'.code])
        assertEquals(1, result.graphemsMap['<'.code])
        assertEquals(1, result.graphemsMap['>'.code])
        assertEquals(1, result.graphemsMap['.'.code])
        assertEquals(2, result.graphemsMap['('.code])
        assertEquals(2, result.graphemsMap[')'.code])
        assertEquals(2, result.graphemsMap['*'.code])
        assertEquals(1, result.graphemsMap['{'.code])
        assertEquals(1, result.graphemsMap['}'.code])
    }
}
