package ch.addere.keystrokeenumerator.application

import domain.model.layout.LayoutFiles
import domain.model.layout.LayoutFiles.DE_CH
import domain.model.layout.LayoutFiles.EN_US
import domain.service.FileTreeProcessorImpl
import domain.service.load.LayoutLoader
import domain.service.mergeSymbolCounters
import java.io.File
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
fun main(args: Array<String>) {

    val fileTreeProcessor = FileTreeProcessorImpl()
    val measureTimedValue = measureTimedValue {
        fileTreeProcessor.countSymbolsWithinFileTree(File(args[0]), Charsets.UTF_8)
    }
    val results = measureTimedValue.value
    val duration = measureTimedValue.duration


    val symbolToOccurrence = mergeSymbolCounters(results.map { it.symbolCounter })

    val layoutLoader = LayoutLoader()
    val layouts = layoutLoader.loadLayouts(listOf(DE_CH, EN_US))
    val layout0Count =
        symbolToOccurrence.entries.stream()
            .mapToInt { layouts[0].countKeystrokeFor(it.key).orElse(0) * it.value }
            .sum()
    val layout1Count =
        symbolToOccurrence.entries.stream()
            .mapToInt { layouts[1].countKeystrokeFor(it.key).orElse(0) * it.value }
            .sum()

    val totalFiles = results.size
    val totalByteSize = results.sumOf { it.fileSize }
    val totalUniqueSymbols =
        results.flatMap { it.symbolCounter.getSymbolCounts().keys }.toSet().count()
    val totalSymbols = results.sumOf { it.symbolCounter.totalSymbolsProcessed() }
    val totalLinesOfCode = results.sumOf { it.totalLineBreaks() }

    println()
    println("Scanned $totalFiles files of $totalByteSize bytes in $duration")
    println("Found $totalUniqueSymbols unique in $totalSymbols symbols on $totalLinesOfCode lines")

    val redundancy0 = layout0Count / totalSymbols.toDouble() - 1.0
    val redundancy1 = layout1Count / totalSymbols.toDouble() - 1.0
    println()
    println("Layout\tKeystrokes\tRedundancy")
    println(String.format("${layouts[0].name}\t$layout0Count\t\t%.3f", redundancy0))
    println(String.format("${layouts[1].name}\t$layout1Count\t\t%.3f", redundancy1))
    println()
}
