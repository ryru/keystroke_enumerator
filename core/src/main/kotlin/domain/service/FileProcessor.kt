package domain.service

import domain.model.FileResult
import java.io.File
import java.nio.charset.Charset

interface FileProcessor {

    /**
     * Count symbols within file.
     */
    fun countSymbols(file: File, charset: Charset): FileResult
}
