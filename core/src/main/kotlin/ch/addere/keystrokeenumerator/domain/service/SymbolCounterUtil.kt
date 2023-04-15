package ch.addere.keystrokeenumerator.domain.service

import ch.addere.keystrokeenumerator.domain.model.symbol.Symbol
import ch.addere.keystrokeenumerator.domain.model.symbol.SymbolCounter


/**
 * Merge multiple {@link SymbolCounter} into a single map. Symbols are summed together.
 */
fun mergeSymbolCounters(symbolCounters: List<SymbolCounter>): Map<Symbol, Int> {
    val result = mutableMapOf<Symbol, Int>()
    symbolCounters.map { it.getSymbolCounts() }.forEach {
        val entries = it.entries
        entries.forEach { entry ->
            val numberOfOccurrence = if (result.containsKey(entry.key)) {
                result.getValue(entry.key) + entry.value
            } else {
                entry.value
            }
            result[entry.key] = numberOfOccurrence
        }
    }
    return result
}

