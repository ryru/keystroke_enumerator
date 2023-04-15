package ch.addere.keystrokeenumerator.domain.model.layout

import ch.addere.keystrokeenumerator.domain.model.key.SymbolKeyStroke
import ch.addere.keystrokeenumerator.domain.model.key.VirtualKey.CONTROL
import ch.addere.keystrokeenumerator.domain.model.key.VirtualKey.SHIFT
import ch.addere.keystrokeenumerator.domain.model.key.VirtualKey.SPACE
import ch.addere.keystrokeenumerator.domain.model.key.VirtualKey.U
import ch.addere.keystrokeenumerator.domain.model.symbol.Symbol

private const val BITS_PER_HEX_SYMBOL = 4

/**
 * Keyboard layout consists of a name and a symbol to virtual key mapping.
 */
class Layout(val name: String, private val symbolKeyMap: Set<SymbolKeyStroke>) {

    private val linuxUnicodeCombination = listOf(CONTROL, SHIFT, U, SPACE)

    /**
     * Count keystrokes for given symbol.
     */
    fun countKeystrokeFor(symbol: Symbol): Int {
        return symbolKeyMap.stream()
            .filter { symbol == it.symbol }
            .map { it.keyStrokeCount() }
            .findFirst()
            .orElseGet { calculateUnicodeKeystrokeCombination(symbol) }
    }

    private fun calculateUnicodeKeystrokeCombination(symbol: Symbol): Int {
        val amountOfBitsSetInSymbol = 32 - symbol.value.countLeadingZeroBits()
        var amountOfHexSymbols = amountOfBitsSetInSymbol / BITS_PER_HEX_SYMBOL
        if (amountOfBitsSetInSymbol % 4 != 0) {
            amountOfHexSymbols++
        }
        return amountOfHexSymbols + linuxUnicodeCombination.size
    }
}
