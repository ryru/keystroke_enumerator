package domain.model.layout

import domain.model.key.SymbolKeyStroke
import domain.model.key.VirtualKey.CONTROL
import domain.model.key.VirtualKey.SHIFT
import domain.model.key.VirtualKey.U
import domain.model.symbol.Symbol

/**
 * Keyboard layout consists of a name and a symbol to virtual key mapping.
 */
class Layout(val name: String, private val symbolKeyMap: Set<SymbolKeyStroke>) {

    private val linuxUnicodeCombination = listOf(CONTROL, SHIFT, U)

    /**
     * Count keystrokes for given symbol or empty if symbol is not printable with layout.
     */
    fun countKeystrokeFor(symbol: Symbol): Int {
        return symbolKeyMap.stream()
            .filter { symbol == it.symbol }
            .map { it.keyStrokeCount() }
            .findFirst()
            .orElseGet {
                val bitsUsed = 32 - symbol.value.countLeadingZeroBits()
                var result = bitsUsed / 4
                if (result != 0) {
                    result++
                }
                result + linuxUnicodeCombination.size
            }
    }
}
