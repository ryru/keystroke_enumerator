package ch.addere.keystrokeenumerator.app.application

import ch.addere.keystrokeenumerator.app.domain.model.AppSettings
import ch.addere.keystrokeenumerator.app.domain.service.ExecutionService
import ch.addere.keystrokeenumerator.app.infrastructure.modules.appModule
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.PrintMessage
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.optional
import com.github.ajalt.clikt.parameters.options.eagerOption
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.path
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutFiles.DE_CH
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutFiles.DE_DE
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutFiles.EN_US
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutFiles.FR_CH
import ch.addere.keystrokeenumerator.core.domain.model.layout.LayoutFiles.FR_FR
import ch.addere.keystrokeenumerator.app.infrastructure.modules.coreModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import java.lang.IllegalArgumentException
import java.nio.file.Path
import kotlin.text.Charsets.UTF_8

class KeystrokeEnumerator :
    CliktCommand(help = "Enumerate keystrokes in FILE per keyboard layout."),
    KoinComponent {

    private val file: Path? by argument().path().optional()

    private val isPrintSupportedLayouts: Boolean by option(
        "--supported-layouts",
        help = "Print all supported keyboard layouts"
    ).flag(default = false)

    private val isPrintSupportedFileTypes: Boolean by option(
        "--supported-fileextensions",
        help = "Print all supported file extensions"
    ).flag(default = false)

    init {
        startKoin {
            modules(appModule)
            modules(coreModule)
        }

        eagerOption(names = setOf("-V", "--version"), help = "Show version number and exit") {
            val versionFromFile = javaClass.classLoader.getResourceAsStream("version.txt")!!
                .bufferedReader(UTF_8).readLine()
            throw PrintMessage(versionFromFile)
        }
    }

    override fun run() {
        val settings = AppSettings(
            path = file,
            layouts = listOf(DE_CH, DE_DE, EN_US, FR_CH, FR_FR),
            isPrintSupportedLayouts = isPrintSupportedLayouts,
            isPrintSupportedFileTypes = isPrintSupportedFileTypes,
        )
        val executionService = get<ExecutionService> { parametersOf(settings) }
        try {
            executionService.run()
        } catch (e: IllegalArgumentException) {
            throw PrintMessage("error: ${e.message}")
        }
    }
}

fun main(args: Array<String>) = KeystrokeEnumerator().main(args)
