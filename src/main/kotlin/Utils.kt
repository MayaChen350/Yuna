import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.channel.asChannelOf
import dev.kord.core.entity.Message
import dev.kord.core.entity.channel.TextChannel

fun clickableButton(name: String, link: String): String {
    return "[[$name ↗]](<$link>)"
}

suspend fun getMessageFromLink(message: String) : Message {
    val splitMessage = message.split("/")
    val channelId = Snowflake(splitMessage[5].toLong())
    val messageId = Snowflake(splitMessage[6].toLong())
    val channel = kord.getGuild(guildId).getChannel(channelId).asChannelOf<TextChannel>()
    return channel.getMessage(messageId)
}

suspend fun getMessageLink(message: Message): String {
    return "https://discord.com/channels/${message.getGuild().id}/${message.channelId.value}/${message.id.value}"
}