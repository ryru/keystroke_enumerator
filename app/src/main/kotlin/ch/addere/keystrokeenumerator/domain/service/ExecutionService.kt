package ch.addere.keystrokeenumerator.domain.service

import ch.addere.keystrokeenumerator.domain.model.AppSettings
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
import kotlin.time.Duration
import kotlin.time.DurationUnit.SECONDS
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

class ExecutionService {

    @OptIn(ExperimentalTime::class)
    fun execute(settings: AppSettings) {

        val measureTimedValue = processFiles(settings.path)
        val results = measureTimedValue.value

        val symbolToOccurrence = mergeSymbolCounters(results.map { it.symbolCounter })
        val strokesPerLayouts = toStrokesPerLayouts(symbolToOccurrence)

        val totalSymbols = results.sumOf { it.symbolCounter.totalSymbolsProcessed() }
        printHeader(results, measureTimedValue.duration, totalSymbols)
        printTable(strokesPerLayouts, totalSymbols)
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

    private fun printHeader(results: List<FileResult>, duration: Duration, totalSymbols: Int) {
        val totalFiles = results.size
        val totalByteSize = results.sumOf { it.fileSize }
        val totalUniqueSymbols =
            results.flatMap { it.symbolCounter.getSymbolCounts().keys }.toSet().count()
        val totalLinesOfCode = results.sumOf { it.totalLineBreaks() }
        println()
        println(
            "Scanned $totalFiles files of $totalByteSize bytes in ${
                duration.toString(
                    SECONDS,
                    3
                )
            }"
        )
        println("Found $totalUniqueSymbols unique in $totalSymbols symbols on $totalLinesOfCode lines")
        println()
    }

    private fun printTable(strokesPerLayouts: List<LayoutResult>, totalSymbols: Int) {
        println("Layout\tKeystrokes\tRedundancy[%]")
        val sortedStrokesPerLayout = strokesPerLayouts.sortedBy { it.totalKeystrokes }
        sortedStrokesPerLayout.forEach { strokesPerLayout ->
            val totalKeystrokes = strokesPerLayout.totalKeystrokes
            val redundancy = totalKeystrokes.toDouble() * 100 / totalSymbols.toDouble() - 100
            val layoutName = strokesPerLayout.layout
            println(String.format("$layoutName\t$totalKeystrokes\t\t%.3f", redundancy))
        }
        println()

        val firstLayout = sortedStrokesPerLayout.first()
        val lastLayout = sortedStrokesPerLayout.last()
        if (firstLayout.totalKeystrokes == lastLayout.totalKeystrokes) {
            println("First and last layout provide the same efficiency.")
        } else {
            val diffAbsolute = lastLayout.totalKeystrokes - firstLayout.totalKeystrokes
            val diffPercent =
                lastLayout.totalKeystrokes.toDouble() * 100 / firstLayout.totalKeystrokes.toDouble() - 100
            println(
                String.format(
                    "Layout %s requires %d keystrokes (%.3f%%) less than layout %s",
                    firstLayout.layout,
                    diffAbsolute,
                    diffPercent,
                    lastLayout.layout
                )
            )
        }
        println()
    }
}
