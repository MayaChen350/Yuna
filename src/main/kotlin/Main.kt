import cz.lukynka.prettylog.LogType
import cz.lukynka.prettylog.log
import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent

lateinit var kord: Kord

@OptIn(PrivilegedIntent::class)
suspend fun main(args: Array<String>) {
    log("Loading Yuna..", LogType.DEBUG)
    log("Authenticating to Discord..", LogType.NETWORK)
    kord = Kord(Environment.DISCORD_TOKEN)


    kord.login {
        presence { playing("Yuna ver ") }
        intents += Intent.MessageContent
    }
}