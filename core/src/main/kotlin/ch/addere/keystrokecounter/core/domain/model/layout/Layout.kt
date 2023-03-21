package ch.addere.keystrokecounter.core.domain.model.layout

import ch.addere.keystrokecounter.core.domain.model.key.SymbolKeyStroke

/**
 * Keyboard layout consists of a name and a symbol to virtual key mapping.
 */
data class Layout(val name: String, val symbolKeyMap: MutableSet<SymbolKeyStroke>) {

    /**
     * Add a symbol to virtual key mapping to this layout.
     */
    fun addSymbolToVirtualKeyMapping(symbolToVirtualKey: SymbolKeyStroke) {
        symbolKeyMap.add(symbolToVirtualKey)
    }
}
