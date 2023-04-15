package ch.addere.keystrokeenumerator.app.infrastructure.modules

import ch.addere.keystrokeenumerator.core.domain.service.FileProcessor
import ch.addere.keystrokeenumerator.core.domain.service.FileTreeProcessor
import ch.addere.keystrokeenumerator.core.domain.service.FileTreeProcessorImpl
import ch.addere.keystrokeenumerator.core.domain.service.FileProcessorImpl
import ch.addere.keystrokeenumerator.core.domain.service.fileextension.FileExtensionService
import ch.addere.keystrokeenumerator.core.domain.service.load.LayoutLoader
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coreModule = module {
    singleOf(::FileExtensionService)
    singleOf(::FileProcessorImpl) { bind<FileProcessor>() }
    singleOf(::FileTreeProcessorImpl) { bind<FileTreeProcessor>() }
    singleOf(::LayoutLoader)
}
