package ch.addere.keystrokeenumerator.core.domain.service

import domain.model.FileResult
import domain.model.symbol.A
import domain.model.symbol.C
import domain.model.symbol.D
import domain.model.symbol.E
import domain.model.symbol.F
import domain.model.symbol.G
import domain.model.symbol.H
import domain.model.symbol.H_CAPITAL
import domain.model.symbol.I
import domain.model.symbol.L
import domain.model.symbol.M
import domain.model.symbol.N
import domain.model.symbol.O
import domain.model.symbol.P
import domain.model.symbol.R
import domain.model.symbol.S
import domain.model.symbol.Symbol
import domain.model.symbol.T
import domain.model.symbol.U
import domain.model.symbol.W_CAPITAL
import domain.service.FileProcessorImpl
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

            val cFile = File("src/test/resources/singleFiles/main_whitespace_utf8.c")
            val result = fileProcessor.countSymbols(cFile, UTF_8)

            assertEquals(88, result.totalSymbolsProcessed())
            assertEquals(88, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInUtf8() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/singleFiles/main_tab_utf8.c")
            val result = fileProcessor.countSymbols(cFile, UTF_8)

            assertEquals(82, result.totalSymbolsProcessed())
            assertEquals(82, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithSpaceInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/singleFiles/main_whitespace_utf16.c")
            val result = fileProcessor.countSymbols(cFile, UTF_16)

            assertEquals(88, result.totalSymbolsProcessed())
            assertEquals(178, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/singleFiles/main_tab_utf16.c")
            val result = fileProcessor.countSymbols(cFile, UTF_16)

            assertEquals(82, result.totalSymbolsProcessed())
            assertEquals(166, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithSpaceInWesternIso_8859_1() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/singleFiles/main_whitespace_western.c")
            val result = fileProcessor.countSymbols(cFile, ISO_8859_1)

            assertEquals(88, result.totalSymbolsProcessed())
            assertEquals(88, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInWesternIso_8859_1() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/singleFiles/main_tab_western.c")
            val result = fileProcessor.countSymbols(cFile, ISO_8859_1)

            assertEquals(82, result.totalSymbolsProcessed())
            assertEquals(82, result.fileSize)
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
                File("src/test/resources/singleFiles/special_characters_utf8.txt")
            val result = fileProcessor.countSymbols(specialFile, UTF_8)

            assertEquals("txt", result.fileExtension)
            assertEquals(69, result.fileSize)
            assertEquals(34, result.totalSymbolsProcessed())
            assertEquals(17, result.totalLineBreaks())
        }

        @Test
        fun testReadSpecialCharactersInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val specialFile =
                File("src/test/resources/singleFiles/special_characters_utf16.txt")
            val result = fileProcessor.countSymbols(specialFile, UTF_16)

            assertEquals("txt", result.fileExtension)
            assertEquals(72, result.fileSize)
            assertEquals(34, result.totalSymbolsProcessed())
            assertEquals(17, result.totalLineBreaks())
        }
    }

    @Nested
    class EmojiSymbols {

        @Test
        fun testReadEmojiSymbolsInUtf8() {
            val fileProcessor = FileProcessorImpl()

            val emojiFile =
                File("src/test/resources/singleFiles/emoji_utf8.txt")
            val result = fileProcessor.countSymbols(emojiFile, UTF_8)

            assertEquals("txt", result.fileExtension)
            assertEquals(32, result.fileSize)
            assertEquals(11, result.totalSymbolsProcessed())
            assertEquals(4, result.totalLineBreaks())
        }

        @Test
        fun testReadEmojiSymbolsInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val emojiFile =
                File("src/test/resources/singleFiles/emoji_utf16.txt")
            val result = fileProcessor.countSymbols(emojiFile, UTF_16)

            assertEquals("txt", result.fileExtension)
            assertEquals(38, result.fileSize)
            assertEquals(11, result.totalSymbolsProcessed())
            assertEquals(4, result.totalLineBreaks())
        }
    }
}
