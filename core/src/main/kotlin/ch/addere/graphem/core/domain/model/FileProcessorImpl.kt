package ch.addere.graphem.core.domain.model

import java.io.File
import java.nio.charset.Charset

class FileProcessorImpl : FileProcessor {

    private var graphems = mutableMapOf<Int, Int>()

    override fun countGraphems(file: File, charset: Charset): FileResult {
        var countLineBreaks = 0
        var countGraphems = 0
        file.forEachLine(charset = charset) { line ->
            countLineBreaks++
            countGraphems++ // count line break character
            line.chars().forEach { char ->
                countGraphems++
                addGraphems(char)
            }
        }
        return FileResult(file.extension, graphems, countLineBreaks, countGraphems)
    }

    private fun addGraphems(graphem: Int) {
        if (graphems.containsKey(graphem)) {
            val counter = graphems[graphem]!!
            graphems[graphem] = counter.inc()
        } else {
            graphems[graphem] = 1
        }
    }
}
