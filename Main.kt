package cz.lukynka

import dev.kord.core.Kord
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv


object Main {
    var dotenv: Dotenv = Dotenv.load()
}

suspend fun main() {


    val kord = Kord()
    println("Hello World!")
}