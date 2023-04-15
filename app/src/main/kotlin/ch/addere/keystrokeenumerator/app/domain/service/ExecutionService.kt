package ch.addere.keystrokeenumerator.app.domain.service

import ch.addere.keystrokeenumerator.app.domain.model.AppSettings
import ch.addere.keystrokeenumerator.app.domain.service.output.PrinterService
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutFiles
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
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


        val scannerService = get<ScannerService> { parametersOf(settings) }
        val outputData = scannerService.execute()

        val printerService = get<PrinterService> { parametersOf(outputData) }
        printerService.printHead()
        printerService.printTable()
    }
}
