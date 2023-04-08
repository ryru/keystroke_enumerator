package domain.model.layout

import domain.model.key.SymbolKeyStroke
import domain.model.key.VirtualKey.A
import domain.model.key.VirtualKey.B
import domain.model.key.VirtualKey.E
import domain.model.key.VirtualKey.SHIFT
import domain.model.symbol.Symbol
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LayoutTest {

    private val symbolA = Symbol("A".codePointAt(0))
    private val symbolB = Symbol("B".codePointAt(0))
    private val symbolX = Symbol("X".codePointAt(0))
    private val symbolEmoji1 = Symbol("👠".codePointAt(0))
    private val symbolEmoji2 = Symbol("😀".codePointAt(0))

    @Test
    fun testMissingSymbolInLayout() {
        val result = layout().countKeystrokeFor(symbolX)
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun testSingleKeySymbolInLayout() {
        val result = layout().countKeystrokeFor(symbolA)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun testMultiKeySymbolInLayout() {
        val result = layout().countKeystrokeFor(symbolB)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun testEmojiSymbolInLayout() {
        val result = layout().countKeystrokeFor(symbolEmoji1)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun testMissingEmojiSymbolInLayout() {
        val result = layout().countKeystrokeFor(symbolEmoji2)
        assertThat(result).isEqualTo(9)
    }

    private fun layout(): Layout {
        val a = SymbolKeyStroke(symbolA, listOf(A))
        val b = SymbolKeyStroke(symbolB, listOf(SHIFT, B))
        val emoji = SymbolKeyStroke(symbolEmoji1, listOf(E))
        return Layout("dummy", setOf(a, b, emoji))
    }
}
