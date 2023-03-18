package ch.addere.graphem.core.domain.service

import ch.addere.graphem.core.domain.model.FileResult
import java.io.File
import java.nio.charset.Charset

interface FileProcessor {

    /**
     * Count graphems within file.
     */
    fun countGraphems(file: File, charset: Charset): FileResult
}
