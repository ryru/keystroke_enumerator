package ch.addere.keystrokecounter.core.domain.service

import ch.addere.keystrokecounter.core.domain.model.A
import ch.addere.keystrokecounter.core.domain.model.C
import ch.addere.keystrokecounter.core.domain.model.D
import ch.addere.keystrokecounter.core.domain.model.E
import ch.addere.keystrokecounter.core.domain.model.F
import ch.addere.keystrokecounter.core.domain.model.FileResult
import ch.addere.keystrokecounter.core.domain.model.G
import ch.addere.keystrokecounter.core.domain.model.H
import ch.addere.keystrokecounter.core.domain.model.H_CAPITAL
import ch.addere.keystrokecounter.core.domain.model.I
import ch.addere.keystrokecounter.core.domain.model.L
import ch.addere.keystrokecounter.core.domain.model.M
import ch.addere.keystrokecounter.core.domain.model.N
import ch.addere.keystrokecounter.core.domain.model.O
import ch.addere.keystrokecounter.core.domain.model.P
import ch.addere.keystrokecounter.core.domain.model.R
import ch.addere.keystrokecounter.core.domain.model.S
import ch.addere.keystrokecounter.core.domain.model.Symbol
import ch.addere.keystrokecounter.core.domain.model.T
import ch.addere.keystrokecounter.core.domain.model.U
import ch.addere.keystrokecounter.core.domain.model.W_CAPITAL
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.text.Charsets.ISO_8859_1
import kotlin.text.Charsets.UTF_16
import kotlin.text.Charsets.UTF_8

class FileProcessorImplTest {

    @Nested
    class CProgrammingLanguage {

        @Test
        fun testReadCFileWithSpaceInUtf8() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/main_whitespace_utf8.c")
            val result = fileProcessor.countSymbols(cFile, UTF_8)

            assertEquals(88, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInUtf8() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/main_tab_utf8.c")
            val result = fileProcessor.countSymbols(cFile, UTF_8)

            assertEquals(82, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithSpaceInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/main_whitespace_utf16.c")
            val result = fileProcessor.countSymbols(cFile, UTF_16)

            assertEquals(88, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/main_tab_utf16.c")
            val result = fileProcessor.countSymbols(cFile, UTF_16)

            assertEquals(82, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithSpaceInWesternIso_8859_1() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/main_whitespace_western.c")
            val result = fileProcessor.countSymbols(cFile, ISO_8859_1)

            assertEquals(88, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInWesternIso_8859_1() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/main_tab_western.c")
            val result = fileProcessor.countSymbols(cFile, ISO_8859_1)

            assertEquals(82, result.totalSymbolsProcessed())
            assertContent(result)
        }

        private fun assertContent(result: FileResult) {
            assertEquals("c", result.fileExtension)
            assertEquals(6, result.totalLineBreaks())

            val symbolMap = result.symbolCounter.getSymbolCounts()

            assertEquals(3, symbolMap[A])
            assertEquals(2, symbolMap[C])
            assertEquals(3, symbolMap[D])
            assertEquals(3, symbolMap[E])
            assertEquals(1, symbolMap[F])
            assertEquals(1, symbolMap[G])
            assertEquals(2, symbolMap[H])
            assertEquals(1, symbolMap[H_CAPITAL])
            assertEquals(5, symbolMap[I])
            assertEquals(4, symbolMap[L])
            assertEquals(1, symbolMap[M])
            assertEquals(5, symbolMap[N])
            assertEquals(3, symbolMap[O])
            assertEquals(1, symbolMap[P])
            assertEquals(6, symbolMap[R])
            assertEquals(2, symbolMap[S])
            assertEquals(4, symbolMap[T])
            assertEquals(2, symbolMap[U])
            assertEquals(1, symbolMap[W_CAPITAL])
            assertEquals(1, symbolMap[Symbol('#'.code)])
            assertEquals(1, symbolMap[Symbol('<'.code)])
            assertEquals(1, symbolMap[Symbol('>'.code)])
            assertEquals(1, symbolMap[Symbol('.'.code)])
            assertEquals(2, symbolMap[Symbol('('.code)])
            assertEquals(2, symbolMap[Symbol(')'.code)])
            assertEquals(2, symbolMap[Symbol('*'.code)])
            assertEquals(1, symbolMap[Symbol('{'.code)])
            assertEquals(1, symbolMap[Symbol('}'.code)])
        }
    }

    @Nested
    class SpecialCharacters {

        @Test
        fun testReadSpecialCharactersInUtf8() {
            val fileProcessor = FileProcessorImpl()

            val specialFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/special_characters_utf8.txt")
            val result = fileProcessor.countSymbols(specialFile, UTF_8)

            assertEquals("txt", result.fileExtension)
            assertEquals(34, result.totalSymbolsProcessed())
            assertEquals(17, result.totalLineBreaks())
        }

        @Test
        fun testReadSpecialCharactersInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val specialFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/special_characters_utf16.txt")
            val result = fileProcessor.countSymbols(specialFile, UTF_16)

            assertEquals("txt", result.fileExtension)
            assertEquals(34, result.totalSymbolsProcessed())
            assertEquals(17, result.totalLineBreaks())
        }
    }

    @Nested
    class EmojiSymbols {

        @Test
        fun testReadEmojiSymbolsInUtf8() {
            val fileProcessor = FileProcessorImpl()

            val specialFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/emoji_utf8.txt")
            val result = fileProcessor.countSymbols(specialFile, UTF_8)

            assertEquals("txt", result.fileExtension)
            assertEquals(11, result.totalSymbolsProcessed())
            assertEquals(4, result.totalLineBreaks())
        }

        @Test
        fun testReadEmojiSymbolsInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val specialFile =
                File("src/test/resources/ch/addere/keystrokecounter/core/domain/model/emoji_utf16.txt")
            val result = fileProcessor.countSymbols(specialFile, UTF_16)

            assertEquals("txt", result.fileExtension)
            assertEquals(11, result.totalSymbolsProcessed())
            assertEquals(4, result.totalLineBreaks())
        }
    }
}
