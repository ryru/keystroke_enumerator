package ch.addere.keystrokecounter.core.domain.model.layout

import ch.addere.keystrokecounter.core.domain.model.key.SymbolKeyStroke
import ch.addere.keystrokecounter.core.domain.model.symbol.Symbol
import java.util.*

/**
 * Keyboard layout consists of a name and a symbol to virtual key mapping.
 */
class Layout(val name: String, private val symbolKeyMap: Set<SymbolKeyStroke>) {

    /**
     * Count keystrokes for given symbol or empty if symbol is not printable with layout.
     */
    fun countKeystrokeFor(symbol: Symbol): Optional<Int> {
        return symbolKeyMap.stream()
            .filter { symbol == it.symbol }
            .map { it.keyStrokeCount() }
            .findFirst();
    }
}
