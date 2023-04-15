package ch.addere.keystrokeenumerator.app.infrastructure.modules

import ch.addere.keystrokeenumerator.app.domain.service.ExecutionService
import ch.addere.keystrokeenumerator.app.domain.service.ScannerService
import ch.addere.keystrokeenumerator.app.domain.service.output.PrinterService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::ExecutionService)
    singleOf(::PrinterService)
    singleOf(::ScannerService)
}
