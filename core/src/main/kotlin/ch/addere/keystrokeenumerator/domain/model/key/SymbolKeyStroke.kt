package ch.addere.keystrokeenumerator.domain.model.key

import ch.addere.keystrokeenumerator.domain.model.symbol.Symbol

/**
 * A symbol maps to a list of keystrokes.
 */
data class SymbolKeyStroke(val symbol: Symbol, private val virtualKeyStrokes: List<VirtualKey>) {

    /**
     * Amount of keystrokes to generate this symbol.
     */
    fun keyStrokeCount(): Int {
        return virtualKeyStrokes.size
    }
}
