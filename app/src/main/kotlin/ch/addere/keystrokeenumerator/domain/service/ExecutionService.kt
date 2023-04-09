package ch.addere.keystrokeenumerator.domain.service

import ch.addere.keystrokeenumerator.domain.model.AppSettings
import ch.addere.keystrokeenumerator.domain.model.output.OutputData
import domain.model.FileResult
import domain.model.layout.LayoutFiles.DE_CH
import domain.model.layout.LayoutFiles.DE_DE
import domain.model.layout.LayoutFiles.EN_US
import domain.model.layout.LayoutFiles.FR_CH
import domain.model.layout.LayoutFiles.FR_FR
import domain.model.layout.LayoutResult
import domain.model.symbol.Symbol
import domain.service.FileTreeProcessorImpl
import domain.service.load.LayoutLoader
import domain.service.mergeSymbolCounters
import java.nio.file.Path
import kotlin.text.Charsets.UTF_8
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

class ExecutionService(private val settings: AppSettings) {

    @OptIn(ExperimentalTime::class)
    fun execute(): OutputData {

        val measureTimedValue = processFiles(settings.path)
        val results = measureTimedValue.value

        val symbolToOccurrence = mergeSymbolCounters(results.map { it.symbolCounter })
        val strokesPerLayouts = toStrokesPerLayouts(symbolToOccurrence)

        val totalSymbols = results.sumOf { it.symbolCounter.totalSymbolsProcessed() }
        return OutputData(results, measureTimedValue.duration, totalSymbols, strokesPerLayouts)
    }

    @OptIn(ExperimentalTime::class)
    private fun processFiles(filePath: Path): TimedValue<List<FileResult>> {
        val fileTreeProcessor = FileTreeProcessorImpl()
        val measureTimedValue = measureTimedValue {
            fileTreeProcessor.countSymbolsWithinFileTree(filePath.toFile(), UTF_8)
        }
        return measureTimedValue
    }

    private fun toStrokesPerLayouts(symbolToOccurrence: Map<Symbol, Int>): List<LayoutResult> {
        val layoutLoader = LayoutLoader()
        val layouts = layoutLoader.loadLayouts(listOf(DE_CH, DE_DE, EN_US, FR_CH, FR_FR))

        val strokesPerLayouts = mutableListOf<LayoutResult>()
        for (layout in layouts) {
            val sum = symbolToOccurrence.entries.stream()
                .mapToInt { layout.countKeystrokeFor(it.key) * it.value }
                .sum()
            strokesPerLayouts.add(LayoutResult(layout.name, sum))
        }
        return strokesPerLayouts
    }
}
