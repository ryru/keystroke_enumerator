package ch.addere.keystrokeenumerator.application

import ch.addere.keystrokeenumerator.domain.model.AppSettings
import ch.addere.keystrokeenumerator.domain.service.ExecutionService
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.PrintMessage
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.eagerOption
import com.github.ajalt.clikt.parameters.types.path
import java.nio.file.Path

class KeystrokeEnumerator : CliktCommand() {

    private val file: Path by argument(help = "File or Path to enumerate keystrokes over").path()

    init {
        eagerOption(names = setOf("-V", "--version"), help = "Show version number and exit") {
            val versionFromFile = javaClass.classLoader.getResourceAsStream("version.txt")!!
                .bufferedReader(Charsets.UTF_8).readLine()
            throw PrintMessage(versionFromFile)
        }
    }

    override fun run() {
        val settings = AppSettings(path = file)
        ExecutionService().execute(settings)
    }
}

fun main(args: Array<String>) = KeystrokeEnumerator().main(args)
