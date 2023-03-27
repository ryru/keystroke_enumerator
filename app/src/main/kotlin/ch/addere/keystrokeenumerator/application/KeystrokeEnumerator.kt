package ch.addere.keystrokeenumerator.application

import domain.model.FileResult
import domain.model.layout.LayoutFiles.DE_CH
import domain.model.layout.LayoutFiles.EN_US
import domain.model.layout.LayoutResult
import domain.model.symbol.Symbol
import domain.service.FileTreeProcessorImpl
import domain.service.load.LayoutLoader
import domain.service.mergeSymbolCounters
import java.io.File
import kotlin.text.Charsets.UTF_8
import kotlin.time.Duration
import kotlin.time.DurationUnit.SECONDS
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
fun main(args: Array<String>) {

    if (args.isEmpty()) {
        println("Error: Require a file or path as argument")
        return
    }

    val measureTimedValue = processFiles(args[0])
    val results = measureTimedValue.value

    val symbolToOccurrence = mergeSymbolCounters(results.map { it.symbolCounter })
    val strokesPerLayouts = toStrokesPerLayouts(symbolToOccurrence)

    val totalSymbols = results.sumOf { it.symbolCounter.totalSymbolsProcessed() }
    printHeader(results, measureTimedValue.duration, totalSymbols)
    printTable(strokesPerLayouts, totalSymbols)
}

@OptIn(ExperimentalTime::class)
private fun processFiles(filePath: String): TimedValue<List<FileResult>> {
    val fileTreeProcessor = FileTreeProcessorImpl()
    val measureTimedValue = measureTimedValue {
        fileTreeProcessor.countSymbolsWithinFileTree(File(filePath), UTF_8)
    }
    return measureTimedValue
}

private fun toStrokesPerLayouts(symbolToOccurrence: Map<Symbol, Int>): List<LayoutResult> {
    val layoutLoader = LayoutLoader()
    val layouts = layoutLoader.loadLayouts(listOf(DE_CH, EN_US))

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
    println("Scanned $totalFiles files of $totalByteSize bytes in ${duration.toString(SECONDS, 3)}")
    println("Found $totalUniqueSymbols unique in $totalSymbols symbols on $totalLinesOfCode lines")
    println()
}

private fun printTable(strokesPerLayouts: List<LayoutResult>, totalSymbols: Int) {
    println("Layout\tKeystrokes\tRedundancy")
    strokesPerLayouts.sortedBy { it.totalKeystrokes }.forEach { strokesPerLayout ->
        val totalKeystrokes = strokesPerLayout.totalKeystrokes
        val redundancy = totalKeystrokes / totalSymbols.toDouble() - 1.0
        val layoutName = strokesPerLayout.layout
        println(String.format("$layoutName\t$totalKeystrokes\t\t%.3f", redundancy))
    }
    println()
}
