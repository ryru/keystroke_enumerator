package ch.addere.keystrokeenumerator.infrastructure.modules

import ch.addere.keystrokeenumerator.domain.service.ExecutionService
import ch.addere.keystrokeenumerator.domain.service.output.PrinterService
import org.koin.dsl.module

val appModule = module {
    single { param -> ExecutionService(param.get()) }
    single { param -> PrinterService(param.get()) }
}
