package ch.addere.keystrokecounter.core.domain.service.importer

import ch.addere.keystrokecounter.core.domain.model.key.SymbolKeyStroke
import ch.addere.keystrokecounter.core.domain.model.key.parse
import ch.addere.keystrokecounter.core.domain.model.layout.Layout
import ch.addere.keystrokecounter.core.domain.model.symbol.from
import org.apache.commons.csv.CSVFormat
import java.io.File
import java.io.FileReader

class CsvImporter {

    fun importLayouts(): MutableList<Layout>? {
        val listOfCsvLayouts = collectCsvLayoutFiles()

        val csvFormat = CSVFormat.DEFAULT.builder()
            .setCommentMarker('#')
            .setHeader("Symbol", "Keystrokes")
            .setSkipHeaderRecord(true)
            .build();

        return listOfCsvLayouts.stream()
            .map { Pair(it.name, FileReader(it)) }
            .map { fileNameAndData ->
                val symbolKeyStrokes = csvFormat.parse(fileNameAndData.second)
                    .map { csvRecord ->
                        val symbol = from(csvRecord.get("Symbol"))
                        val keyStrokes = parse(csvRecord.get("Keystrokes"))
                        SymbolKeyStroke(symbol, keyStrokes)
                    }.toSet()
                Layout(fileNameAndData.first, symbolKeyStrokes)
            }.toList()
    }

    private fun collectCsvLayoutFiles(): List<File> {
        // TODO
        val layoutDir = File("/home/pascal/IdeaProjects/Graphem/core/src/main/resources/layouts/")
        return layoutDir.walk()
            .filter { it.isFile }
            .filter { it.extension == "csv" }
            .toList()
    }
}
