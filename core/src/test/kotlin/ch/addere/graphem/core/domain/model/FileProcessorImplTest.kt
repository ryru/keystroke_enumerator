package ch.addere.graphem.core.domain.model

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
                File("src/test/resources/ch/addere/graphem/core/domain/model/main_whitespace_utf8.c")
            val result = fileProcessor.countGraphems(cFile, UTF_8)

            assertEquals(89, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInUtf8() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/graphem/core/domain/model/main_tab_utf8.c")
            val result = fileProcessor.countGraphems(cFile, UTF_8)

            assertEquals(83, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithSpaceInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/graphem/core/domain/model/main_whitespace_utf16.c")
            val result = fileProcessor.countGraphems(cFile, UTF_16)

            assertEquals(89, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/graphem/core/domain/model/main_tab_utf16.c")
            val result = fileProcessor.countGraphems(cFile, UTF_16)

            assertEquals(83, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithSpaceInWesternIso_8859_1() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/graphem/core/domain/model/main_whitespace_western.c")
            val result = fileProcessor.countGraphems(cFile, ISO_8859_1)

            assertEquals(89, result.totalSymbolsProcessed())
            assertContent(result)
        }

        @Test
        fun testReadCFileWithTabInWesternIso_8859_1() {
            val fileProcessor = FileProcessorImpl()

            val cFile =
                File("src/test/resources/ch/addere/graphem/core/domain/model/main_tab_western.c")
            val result = fileProcessor.countGraphems(cFile, ISO_8859_1)

            assertEquals(83, result.totalSymbolsProcessed())
            assertContent(result)
        }

        private fun assertContent(result: FileResult) {
            assertEquals("c", result.fileExtension)
            assertEquals(7, result.totalLineBreaks())

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
                File("src/test/resources/ch/addere/graphem/core/domain/model/special_characters_utf8.txt")
            val result = fileProcessor.countGraphems(specialFile, UTF_8)

            assertEquals(35, result.totalSymbolsProcessed())
            assertEquals("txt", result.fileExtension)
            assertEquals(17, result.totalLineBreaks())
        }

        @Test
        fun testReadSpecialCharactersInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val specialFile =
                File("src/test/resources/ch/addere/graphem/core/domain/model/special_characters_utf16.txt")
            val result = fileProcessor.countGraphems(specialFile, UTF_16)

            assertEquals(35, result.totalSymbolsProcessed())
            assertEquals("txt", result.fileExtension)
            assertEquals(17, result.totalLineBreaks())
        }
    }

    @Nested
    class EmojiSymbols {

        @Test
        fun testReadEmojiSymbolsInUtf8() {
            val fileProcessor = FileProcessorImpl()

            val specialFile =
                File("src/test/resources/ch/addere/graphem/core/domain/model/emoji_utf8.txt")
            val result = fileProcessor.countGraphems(specialFile, UTF_8)

            assertEquals(18, result.totalSymbolsProcessed())
            assertEquals("txt", result.fileExtension)
            assertEquals(4, result.totalLineBreaks())
        }

        @Test
        fun testReadEmojiSymbolsInUtf16() {
            val fileProcessor = FileProcessorImpl()

            val specialFile =
                File("src/test/resources/ch/addere/graphem/core/domain/model/emoji_utf16.txt")
            val result = fileProcessor.countGraphems(specialFile, UTF_16)

            assertEquals(18, result.totalSymbolsProcessed())
            assertEquals("txt", result.fileExtension)
            assertEquals(4, result.totalLineBreaks())
        }
    }
}
