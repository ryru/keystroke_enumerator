package ch.addere.keystrokeenumerator.core.domain.service.fileextension

import ch.addere.keystrokeenumerator.core.domain.model.fileextension.FileExtension
import java.util.Optional

class FileExtensionService {

    fun fileExtension(extension: String): Optional<FileExtension> {
        return Optional.ofNullable(FileExtension.values().find { it.extension == extension })
    }
}
