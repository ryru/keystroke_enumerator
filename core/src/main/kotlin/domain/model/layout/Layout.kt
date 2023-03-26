package domain.model.layout

import domain.model.key.SymbolKeyStroke
import domain.model.symbol.Symbol
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
