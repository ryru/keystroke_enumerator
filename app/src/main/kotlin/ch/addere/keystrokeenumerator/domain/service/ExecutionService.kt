package ch.addere.keystrokeenumerator.domain.service

import ch.addere.keystrokeenumerator.domain.model.AppSettings
import ch.addere.keystrokeenumerator.domain.service.output.PrinterService
import domain.model.layout.LayoutFiles
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class ExecutionService(private val settings: AppSettings) : KoinComponent {

    fun run() {

        if (settings.isPrintSupportedLayouts) {
            LayoutFiles.values().forEach { println(it) }
            return
        }

        if (settings.path == null) {
            throw IllegalArgumentException("File or path is required")
        }


        val scannerService: ScannerService by inject { parametersOf(settings) }
        val outputData = scannerService.execute()

        val printerService: PrinterService by inject { parametersOf(outputData) }
        printerService.printHead()
        printerService.printTable()
    }
}
