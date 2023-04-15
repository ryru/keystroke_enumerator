package ch.addere.keystrokeenumerator.infrastructure.modules

import ch.addere.keystrokeenumerator.domain.service.ExecutionService
import ch.addere.keystrokeenumerator.domain.service.ScannerService
import ch.addere.keystrokeenumerator.domain.service.output.PrinterService
import ch.addere.keystrokeenumerator.domain.service.FileTreeProcessor
import ch.addere.keystrokeenumerator.domain.service.FileTreeProcessorImpl
import ch.addere.keystrokeenumerator.domain.service.load.LayoutLoader
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single { param -> ExecutionService(param.get()) }
    single { param -> ScannerService(param.get(), get(), get()) }
    single { param -> PrinterService(param.get()) }
    singleOf(::LayoutLoader) {}
    singleOf(::FileTreeProcessorImpl) { bind<FileTreeProcessor>() }
}
