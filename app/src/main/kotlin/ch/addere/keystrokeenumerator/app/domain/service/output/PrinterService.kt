package ch.addere.keystrokeenumerator.app.domain.service.output

import ch.addere.keystrokeenumerator.app.domain.model.output.OutputData
import ch.addere.keystrokeenumerator.core.domain.model.FileResult
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutResult
import kotlin.time.Duration
import kotlin.time.DurationUnit

class PrinterService(private val outputData: OutputData) {

    fun printHead() {
        printHeader(outputData.results, outputData.duration, outputData.totalSymbols)
    }

    fun printTable() {
        printTable(outputData.strokesPerLayouts, outputData.totalSymbols)
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
                    DurationUnit.SECONDS,
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
