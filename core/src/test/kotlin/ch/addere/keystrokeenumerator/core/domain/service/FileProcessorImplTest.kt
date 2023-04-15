package ch.addere.keystrokeenumerator.core.domain.service

import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import ch.addere.keystrokeenumerator.core.domain.model.symbol.A
import ch.addere.keystrokeenumerator.core.domain.model.symbol.A_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.B
import ch.addere.keystrokeenumerator.core.domain.model.symbol.B_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.C
import ch.addere.keystrokeenumerator.core.domain.model.symbol.C_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.D
import ch.addere.keystrokeenumerator.core.domain.model.symbol.D_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.E
import ch.addere.keystrokeenumerator.core.domain.model.symbol.E_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.F
import ch.addere.keystrokeenumerator.core.domain.model.symbol.F_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.G
import ch.addere.keystrokeenumerator.core.domain.model.symbol.G_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.H
import ch.addere.keystrokeenumerator.core.domain.model.symbol.H_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.I
import ch.addere.keystrokeenumerator.core.domain.model.symbol.I_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.J
import ch.addere.keystrokeenumerator.core.domain.model.symbol.J_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.K
import ch.addere.keystrokeenumerator.core.domain.model.symbol.K_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.L
import ch.addere.keystrokeenumerator.core.domain.model.symbol.L_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.M
import ch.addere.keystrokeenumerator.core.domain.model.symbol.M_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.N
import ch.addere.keystrokeenumerator.core.domain.model.symbol.N_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.O
import ch.addere.keystrokeenumerator.core.domain.model.symbol.O_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.P
import ch.addere.keystrokeenumerator.core.domain.model.symbol.P_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Q
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Q_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.R
import ch.addere.keystrokeenumerator.core.domain.model.symbol.R_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.S
import ch.addere.keystrokeenumerator.core.domain.model.symbol.S_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Symbol
import ch.addere.keystrokeenumerator.core.domain.model.symbol.T
import ch.addere.keystrokeenumerator.core.domain.model.symbol.T_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.U
import ch.addere.keystrokeenumerator.core.domain.model.symbol.U_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.V
import ch.addere.keystrokeenumerator.core.domain.model.symbol.V_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.W
import ch.addere.keystrokeenumerator.core.domain.model.symbol.W_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.X
import ch.addere.keystrokeenumerator.core.domain.model.symbol.X_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Y
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Y_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Z
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Z_CAPITAL
import ch.addere.keystrokeenumerator.core.domain.service.fileextension.FileExtensionService
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.text.Charsets.ISO_8859_1
import kotlin.text.Charsets.UTF_16
import kotlin.text.Charsets.UTF_8

class FileProcessorImplTest {

    private val fileProcessor = FileProcessorImpl(FileExtensionService())

    @Test
    fun testLoremIpsum() {
        val lorem = File("src/test/resources/singleFiles/lorem.txt")
        val result = fileProcessor.countSymbols(lorem, UTF_8)

        assertEquals(977, result.totalSymbolsProcessed())
        assertEquals(977, result.fileSize)
        assertEquals(1, result.totalLineBreaks())
        assertEquals("txt", result.fileExtension.extension)
        assertEquals(34, result.symbolCounter.getSymbolCounts().size)
        assertEquals(62, result.symbolCounter.getSymbolCounts()[A])
        assertEquals(8, result.symbolCounter.getSymbolCounts()[B])
        assertEquals(36, result.symbolCounter.getSymbolCounts()[C])
        assertEquals(18, result.symbolCounter.getSymbolCounts()[D])
        assertEquals(93, result.symbolCounter.getSymbolCounts()[E])
        assertEquals(5, result.symbolCounter.getSymbolCounts()[F])
        assertEquals(7, result.symbolCounter.getSymbolCounts()[G])
        assertEquals(4, result.symbolCounter.getSymbolCounts()[H])
        assertEquals(75, result.symbolCounter.getSymbolCounts()[I])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[J])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[K])
        assertEquals(48, result.symbolCounter.getSymbolCounts()[L])
        assertEquals(40, result.symbolCounter.getSymbolCounts()[M])
        assertEquals(46, result.symbolCounter.getSymbolCounts()[N])
        assertEquals(44, result.symbolCounter.getSymbolCounts()[O])
        assertEquals(16, result.symbolCounter.getSymbolCounts()[P])
        assertEquals(12, result.symbolCounter.getSymbolCounts()[Q])
        assertEquals(43, result.symbolCounter.getSymbolCounts()[R])
        assertEquals(70, result.symbolCounter.getSymbolCounts()[S])
        assertEquals(68, result.symbolCounter.getSymbolCounts()[T])
        assertEquals(71, result.symbolCounter.getSymbolCounts()[U])
        assertEquals(5, result.symbolCounter.getSymbolCounts()[V])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[W])
        assertEquals(6, result.symbolCounter.getSymbolCounts()[X])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[Y])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[Z])
        assertEquals(1, result.symbolCounter.getSymbolCounts()[A_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[B_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[C_CAPITAL])
        assertEquals(1, result.symbolCounter.getSymbolCounts()[D_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[E_CAPITAL])
        assertEquals(2, result.symbolCounter.getSymbolCounts()[F_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[G_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[H_CAPITAL])
        assertEquals(2, result.symbolCounter.getSymbolCounts()[I_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[J_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[K_CAPITAL])
        assertEquals(1, result.symbolCounter.getSymbolCounts()[L_CAPITAL])
        assertEquals(2, result.symbolCounter.getSymbolCounts()[M_CAPITAL])
        assertEquals(1, result.symbolCounter.getSymbolCounts()[N_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[O_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[P_CAPITAL])
        assertEquals(2, result.symbolCounter.getSymbolCounts()[Q_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[R_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[S_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[T_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[U_CAPITAL])
        assertEquals(3, result.symbolCounter.getSymbolCounts()[V_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[W_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[X_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[Y_CAPITAL])
        assertEquals(null, result.symbolCounter.getSymbolCounts()[Z_CAPITAL])
    }

    @Nested
    inner class CProgrammingLanguage {

        private val fileProcessor = FileProcessorImpl(FileExtensionService())

        @Test
        fun testReadCFileWithSpaceInUtf8() {
            val cFile = File("src/test/resources/singleFiles/main_whitespace_utf8.c")
            val result = fileProcessor.countSymbols(cFile, UTF_8)

            assertEquals(88, result.totalSymbolsProcessed())
            assertEquals(88, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInUtf8() {
            val cFile = File("src/test/resources/singleFiles/main_tab_utf8.c")
            val result = fileProcessor.countSymbols(cFile, UTF_8)

            assertEquals(82, result.totalSymbolsProcessed())
            assertEquals(82, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithSpaceInUtf16() {
            val cFile = File("src/test/resources/singleFiles/main_whitespace_utf16.c")
            val result = fileProcessor.countSymbols(cFile, UTF_16)

            assertEquals(88, result.totalSymbolsProcessed())
            assertEquals(178, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInUtf16() {
            val cFile = File("src/test/resources/singleFiles/main_tab_utf16.c")
            val result = fileProcessor.countSymbols(cFile, UTF_16)

            assertEquals(82, result.totalSymbolsProcessed())
            assertEquals(166, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithSpaceInWesternIso_8859_1() {
            val cFile = File("src/test/resources/singleFiles/main_whitespace_western.c")
            val result = fileProcessor.countSymbols(cFile, ISO_8859_1)

            assertEquals(88, result.totalSymbolsProcessed())
            assertEquals(88, result.fileSize)
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInWesternIso_8859_1() {
            val cFile = File("src/test/resources/singleFiles/main_tab_western.c")
            val result = fileProcessor.countSymbols(cFile, ISO_8859_1)

            assertEquals(82, result.totalSymbolsProcessed())
            assertEquals(82, result.fileSize)
            assertContent(result)
        }

        private fun assertContent(result: FileResult) {
            assertEquals("c", result.fileExtension.extension)
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
    inner class SpecialCharacters {

        private val fileProcessor = FileProcessorImpl(FileExtensionService())

        @Test
        fun testReadSpecialCharactersInUtf8() {
            val specialFile = File("src/test/resources/singleFiles/special_characters_utf8.txt")
            val result = fileProcessor.countSymbols(specialFile, UTF_8)

            assertEquals("txt", result.fileExtension.extension)
            assertEquals(69, result.fileSize)
            assertEquals(34, result.totalSymbolsProcessed())
            assertEquals(17, result.totalLineBreaks())
        }

        @Test
        fun testReadSpecialCharactersInUtf16() {
            val specialFile = File("src/test/resources/singleFiles/special_characters_utf16.txt")
            val result = fileProcessor.countSymbols(specialFile, UTF_16)

            assertEquals("txt", result.fileExtension.extension)
            assertEquals(72, result.fileSize)
            assertEquals(34, result.totalSymbolsProcessed())
            assertEquals(17, result.totalLineBreaks())
        }
    }

    @Nested
    inner class EmojiSymbols {

        private val fileProcessor = FileProcessorImpl(FileExtensionService())

        @Test
        fun testReadEmojiSymbolsInUtf8() {
            val emojiFile = File("src/test/resources/singleFiles/emoji_utf8.txt")
            val result = fileProcessor.countSymbols(emojiFile, UTF_8)

            assertEquals("txt", result.fileExtension.extension)
            assertEquals(32, result.fileSize)
            assertEquals(11, result.totalSymbolsProcessed())
            assertEquals(4, result.totalLineBreaks())
        }

        @Test
        fun testReadEmojiSymbolsInUtf16() {
            val emojiFile = File("src/test/resources/singleFiles/emoji_utf16.txt")
            val result = fileProcessor.countSymbols(emojiFile, UTF_16)

            assertEquals("txt", result.fileExtension.extension)
            assertEquals(38, result.fileSize)
            assertEquals(11, result.totalSymbolsProcessed())
            assertEquals(4, result.totalLineBreaks())
        }
    }
}
