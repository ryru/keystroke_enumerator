package ch.addere.keystrokeenumerator.application

import ch.addere.keystrokeenumerator.domain.model.AppSettings
import ch.addere.keystrokeenumerator.domain.service.ExecutionService
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.path
import java.nio.file.Path

class KeystrokeEnumerator : CliktCommand() {

    private val file: Path by argument(help = "File or Path to enumerate keystrokes over.").path()

    override fun run() {
        val settings = AppSettings(path = file)
        ExecutionService().execute(settings)
    }
}

fun main(args: Array<String>) = KeystrokeEnumerator().main(args)
