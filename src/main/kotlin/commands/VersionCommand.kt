package commands

import clickableButton
import dev.kord.core.behavior.interaction.response.DeferredPublicMessageInteractionResponseBehavior
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.entity.interaction.InteractionCommand
import guildId
import kord
import version

class VersionCommand {

    suspend fun register() {
        kord.createGuildChatInputCommand(guildId, "version", "Gets the version of Yuna") {}
    }

    companion object {
        suspend fun handle(command: InteractionCommand, response: DeferredPublicMessageInteractionResponseBehavior) {
            response.respond { content = "Currently running on version **${version.version}** `git-${version.gitCommit}@${version.gitBranch}` ${clickableButton("GitHub", "https://github.com/LukynkaCZE/Yuna")}" }
        }
    }
}