import SobBoard.SOB_EMOJI
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.MessageBehavior
import dev.kord.core.behavior.channel.asChannelOf
import dev.kord.core.entity.Message
import dev.kord.core.entity.channel.TextChannel

fun clickableButton(name: String, link: String): String {
    return "[[$name ↗]](<$link>)"
}

suspend fun Message.getUrl(): String {
    return "https://discord.com/channels/${getGuild().id}/${channelId.value}/${id.value}"
}

fun Message.getSobs(): Int {
    return reactions
        .firstOrNull { it.emoji.name == SOB_EMOJI }
        ?.count ?: 0
}
