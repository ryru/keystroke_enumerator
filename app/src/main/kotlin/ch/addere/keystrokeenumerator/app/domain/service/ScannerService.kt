package ch.addere.keystrokeenumerator.app.domain.service

import ch.addere.keystrokeenumerator.app.domain.model.AppSettings
import ch.addere.keystrokeenumerator.app.domain.model.output.OutputData
import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutResult
import ch.addere.keystrokeenumerator.core.domain.model.symbol.Symbol
import ch.addere.keystrokeenumerator.core.domain.service.FileTreeProcessor
import ch.addere.keystrokeenumerator.core.domain.service.load.LayoutLoader
import ch.addere.keystrokeenumerator.core.domain.service.mergeSymbolCounters
import java.nio.file.Path
import kotlin.text.Charsets.UTF_8
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

class ScannerService(
    private val settings: AppSettings,
    private val layoutLoader: LayoutLoader,
    private val fileTreeProcessor: FileTreeProcessor
) {

    @OptIn(ExperimentalTime::class)
    fun execute(): OutputData {

        val measureTimedValue = processFiles(settings.path!!)
        val results = measureTimedValue.value

        val symbolToOccurrence = mergeSymbolCounters(results.map { it.symbolCounter })
        val strokesPerLayouts = toStrokesPerLayouts(symbolToOccurrence)

        val totalSymbols = results.sumOf { it.symbolCounter.totalSymbolsProcessed() }
        return OutputData(results, measureTimedValue.duration, totalSymbols, strokesPerLayouts)
    }

    @OptIn(ExperimentalTime::class)
    private fun processFiles(filePath: Path): TimedValue<List<FileResult>> {
        return measureTimedValue {
            fileTreeProcessor.countSymbolsWithinFileTree(filePath.toFile(), UTF_8)
        }
    }

    private fun toStrokesPerLayouts(symbolToOccurrence: Map<Symbol, Int>): List<LayoutResult> {
        val strokesPerLayouts = mutableListOf<LayoutResult>()
        val layouts = layoutLoader.loadLayouts(settings.layouts)
        for (layout in layouts) {
            val sum = symbolToOccurrence.entries.stream()
                .mapToInt { layout.countKeystrokeFor(it.key) * it.value }
                .sum()
            strokesPerLayouts.add(LayoutResult(layout.name, sum))
        }
        return strokesPerLayouts
    }
}
