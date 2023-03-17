package ch.addere.graphem.core.domain.model

import java.io.File
import java.nio.charset.Charset

interface FileProcessor {

    /**
     * Count graphems within file.
     */
    fun countGraphems(file: File, charset: Charset): FileResult
}
