import commands.VersionCommand
import cz.lukynka.prettylog.LogType
import cz.lukynka.prettylog.log
import dev.kord.core.behavior.interaction.response.DeferredPublicMessageInteractionResponseBehavior
import dev.kord.core.entity.interaction.InteractionCommand

class Commands {
    suspend fun register() {
        VersionCommand().register()
    }
    companion object {

        suspend fun handle(command: InteractionCommand, response: DeferredPublicMessageInteractionResponseBehavior) {
            when(command.rootName) {
                "version" -> VersionCommand.handle(command, response)
                else -> log("Command /${command.rootName} does not have a handler", LogType.ERROR)
            }
        }
    }
}