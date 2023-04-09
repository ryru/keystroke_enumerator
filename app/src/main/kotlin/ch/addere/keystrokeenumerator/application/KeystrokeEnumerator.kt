package ch.addere.keystrokeenumerator.application

import ch.addere.keystrokeenumerator.domain.model.AppSettings
import ch.addere.keystrokeenumerator.domain.service.ExecutionService
import ch.addere.keystrokeenumerator.domain.service.output.PrinterService
import ch.addere.keystrokeenumerator.infrastructure.modules.appModule
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.PrintMessage
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.eagerOption
import com.github.ajalt.clikt.parameters.types.path
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import java.nio.file.Path

class KeystrokeEnumerator : CliktCommand(), KoinComponent {

    private val file: Path by argument(help = "File or Path to enumerate keystrokes over").path()

    init {
        startKoin {
            modules(appModule)
        }

        eagerOption(names = setOf("-V", "--version"), help = "Show version number and exit") {
            val versionFromFile = javaClass.classLoader.getResourceAsStream("version.txt")!!
                .bufferedReader(Charsets.UTF_8).readLine()
            throw PrintMessage(versionFromFile)
        }
    }

    override fun run() {
        val settings = AppSettings(path = file)
        val executionService: ExecutionService by inject { parametersOf(settings) }
        val outputData = executionService.execute()

        val printerService: PrinterService by inject { parametersOf(outputData) }
        printerService.printHead()
        printerService.printTable()
    }
}

fun main(args: Array<String>) = KeystrokeEnumerator().main(args)
