package embeds

import clickableButton
import dev.kord.common.Color
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.channel.asChannelOf
import dev.kord.core.behavior.channel.createEmbed
import dev.kord.core.entity.channel.TextChannel
import guildId
import kord

class Rules {

    suspend fun register() {
        val rulesChannel = kord.getGuild(guildId).getChannel(Snowflake(1249428632359927939)).asChannelOf<TextChannel>()
        rulesChannel.messages.collect { it.delete() }

        rulesChannel.createEmbed {
            title = "**__Rules__**"
            description = """
            - Follow Discord TOS ${clickableButton("Discord TOS", "https://discord.com/terms")}
            - No harassment, bullying, discrimination or anything similar to that
            - No self promotion or advertisement
            - No politics or sensitive topics
            - Be respectful and kind to each-others
            - Worship Kotlin
            - :3
            """.trimIndent()
            color = Color(166, 227, 161)
        }
    }
}