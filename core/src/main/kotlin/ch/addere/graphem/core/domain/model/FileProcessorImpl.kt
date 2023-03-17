package ch.addere.graphem.core.domain.model

import java.io.File
import java.nio.charset.Charset

class FileProcessorImpl : FileProcessor {

    private var graphems = mutableMapOf<Char, Int>()

    override fun countGraphems(file: File, charset: Charset): FileResult {
        var countLineBreaks = 0
        var countGraphems = 0
        file.forEachLine(charset = charset) { line ->
            countLineBreaks++
            line.chars().forEach { char ->
                countGraphems++
                add(char.toChar())
            }
        }
        return FileResult(graphems, countLineBreaks, countGraphems)
    }

    private fun add(char: Char) {
        if (graphems.containsKey(char)) {
            val counter = graphems[char]!!
            graphems[char] = counter.inc()
        } else {
            graphems[char] = 1
        }
    }
}
