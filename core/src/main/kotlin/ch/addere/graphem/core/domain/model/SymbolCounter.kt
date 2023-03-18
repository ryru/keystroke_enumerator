package ch.addere.graphem.core.domain.model

class SymbolCounter {

    private val symbolMap = mutableMapOf<Symbol, Int>()
    private var totalSymbols = 0

    /**
     * Count occurrence of a symbol in an internal counter.
     */
    fun count(symbol: Symbol) {
        totalSymbols++
        if (symbolMap.containsKey(symbol)) {
            val counter = symbolMap[symbol]!!
            symbolMap[symbol] = counter.inc()
        } else {
            symbolMap[symbol] = 1
        }
    }

    /**
     * Amount of symbols processed/countet by this symbol counter. How many times was the method
     * {@link count) called.
     */
    fun totalSymbolsProcessed(): Int {
        return totalSymbols
    }

    /**
     * Returns a map of symbols and their occurrence as a copy.
     */
    fun getSymbolCounts(): Map<Symbol, Int> {
        return symbolMap.toMap()
    }

    /**
     * Returns the amount of occurrences of a given symbol or zero, if the symbol is absent.
     */
    fun getSymbolCount(symbol: Symbol): Int {
        return if (symbolMap.containsKey(symbol)) {
            symbolMap.getValue(symbol)
        } else {
            0
        }
    }
}
