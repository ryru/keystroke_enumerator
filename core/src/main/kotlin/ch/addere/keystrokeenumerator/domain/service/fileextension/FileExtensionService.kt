package ch.addere.keystrokeenumerator.domain.service.fileextension

import ch.addere.keystrokeenumerator.domain.model.fileextension.FileExtension
import java.util.Optional

class FileExtensionService {

    fun isSupportedFileExtension(extension: String): Boolean {
        return fileExtension(extension).isPresent
    }

    fun fileExtension(extension: String): Optional<FileExtension> {
        return Optional.ofNullable(FileExtension.values().find { it.extension == extension })
    }
}
