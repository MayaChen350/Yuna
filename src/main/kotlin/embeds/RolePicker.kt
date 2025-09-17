package embeds

import clickableButton
import dev.kord.common.Color
import dev.kord.common.entity.ButtonStyle
import dev.kord.common.entity.DiscordPartialEmoji
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.channel.asChannelOf
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.entity.channel.TextChannel
import dev.kord.rest.builder.message.actionRow
import dev.kord.rest.builder.message.embed
import guildId
import kord

class RolePicker {

    suspend fun register() {
        val rolesChannel = kord.getGuild(guildId).getChannel(Snowflake(1249503869608788050)).asChannelOf<TextChannel>()
        rolesChannel.messages.collect { message -> if (message.author?.isBot == true) message.delete() }

        rolesChannel.createMessage {
            actionRow {
                interactionButton(ButtonStyle.Secondary, "role-tester") {
                    label = "Tester"
                    emoji = DiscordPartialEmoji(name = "\uD83E\uDDEA")
                }
                interactionButton(ButtonStyle.Secondary, "role-ping-twitch") {
                    label = "Stream"
                    emoji = DiscordPartialEmoji(name = "\uD83D\uDD14")
                }
                interactionButton(ButtonStyle.Secondary, "role-ping-updates") {
                    label = "Updates"
                    emoji = DiscordPartialEmoji(name = "\uD83D\uDD14")
                }
                interactionButton(ButtonStyle.Secondary, "role-ping-dockyard") {
                    label = "DockyardMC Updates"
                    emoji = DiscordPartialEmoji(name = "\uD83C\uDF0A")
                }
            }

            embed {
                title = "Pick Your Role(s)!"
                color = Color(137, 180, 250)
                description = """
            Click on the buttons below to Add/Remove selected role
            
            `🧪 | Project Tester` 
            - Get access to beta/testing section where you can get alpha/testing versions of things like **Pretty Log**, **Better Saved Hotbars**, **Keyboard Tools** etc. and get chance to __participate in testing some of my upcoming Minecraft server projects__
            
            `🔔 | Stream Notifications`
            - Get pinged whenever I go live on Twitch! ${clickableButton("My Twitch", "https://twitch.tv/LukynkaCZE")}
            
            `🔔 | Update Notifications`
            - Get pinged whenever there is new version of things like **Better Saved Hotbars**, **Pretty Log** , **Keyboard Tools** etc.
            
            `🔔 | DockyardMC`
            - Get pinged whenever there is update or changes to **DockyardMC**. This is separate cause most people probably do not care about DockyardMC and are here for other projects 
            
        """.trimIndent()
            }
        }
    }

}