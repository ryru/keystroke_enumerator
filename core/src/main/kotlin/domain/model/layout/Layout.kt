package domain.model.layout

import domain.model.key.SymbolKeyStroke
import domain.model.key.VirtualKey.CONTROL
import domain.model.key.VirtualKey.SHIFT
import domain.model.key.VirtualKey.SPACE
import domain.model.key.VirtualKey.U
import domain.model.symbol.Symbol

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
