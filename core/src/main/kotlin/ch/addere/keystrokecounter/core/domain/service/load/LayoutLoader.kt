package ch.addere.keystrokecounter.core.domain.service.load

import ch.addere.keystrokecounter.core.domain.model.layout.LayoutFiles
import ch.addere.keystrokecounter.core.domain.model.key.SymbolKeyStroke
import ch.addere.keystrokecounter.core.domain.model.key.parse
import ch.addere.keystrokecounter.core.domain.model.layout.Layout
import ch.addere.keystrokecounter.core.domain.model.symbol.from
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import java.io.InputStream
import kotlin.text.Charsets.UTF_8

private const val CSV_COMMENT_MARKER = '#'
private const val CSV_HEADER_SYMBOL = "Symbol"
private const val CSV_HEADER_KEYSTROKES = "Keystrokes"

class LayoutLoader {

    /**
     * Load the requested keyboard layout from the resources.
     */
    fun loadLayouts(layoutFile: List<LayoutFiles>): List<Layout> {

        val csvFormat = CSVFormat.DEFAULT.builder()
            .setCommentMarker(CSV_COMMENT_MARKER)
            .setHeader(CSV_HEADER_SYMBOL, CSV_HEADER_KEYSTROKES)
            .setSkipHeaderRecord(true)
            .build()

        return layoutFile.stream()
            .map { toNameAndStreamReader(it) }
            .map { toLayout(csvFormat, it) }
            .toList()
    }

    private fun toNameAndStreamReader(it: LayoutFiles) = Pair(
        it.name,
        javaClass.classLoader.getResourceAsStream("layouts/${it.filename}")
    )

    private fun toLayout(
        csvFormat: CSVFormat,
        fileNameAndData: Pair<String, InputStream?>
    ): Layout {
        val symbolKeyStrokes =
            csvFormat.parse(fileNameAndData.second!!.bufferedReader(UTF_8))
                .map { csvRecord -> toSymbolKeystroke(csvRecord) }
                .toSet()
        return Layout(fileNameAndData.first, symbolKeyStrokes)
    }

    private fun toSymbolKeystroke(csvRecord: CSVRecord): SymbolKeyStroke {
        val symbol = from(csvRecord.get(CSV_HEADER_SYMBOL))
        val keyStrokes = parse(csvRecord.get(CSV_HEADER_KEYSTROKES))
        return SymbolKeyStroke(symbol, keyStrokes)
    }
}
