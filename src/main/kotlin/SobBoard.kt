import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.behavior.edit
import dev.kord.core.entity.Message
import dev.kord.rest.builder.message.embed

// Key is the board message, value is the original message
val sobbedMessages: MutableMap<Message, String> = mutableMapOf()

object SobBoard {

    suspend fun addMessage(message: Message) {
        val sobs = message.reactions.filter { it.emoji.name == "\uD83D\uDE2D" }[0].data.count

        val boardMessage = sobChannel.createMessage {
            content = getMessageLink(message)
            embed {
                description = if(message.embeds.isEmpty()) {
                    message.content
                } else {
                    message.embeds[0].description
                }
                author {
                    name = message.author?.username
                    icon = message.author?.avatar?.cdnUrl?.toUrl()
                }
                footer {
                    text = "$sobs 😭"

                }
            }
        }
        sobbedMessages.put(boardMessage, getMessageLink(message))
    }

    suspend fun getMessages() {
        sobChannel.messages.collect { boardMessage ->
            if(boardMessage.author?.isBot == false || boardMessage.content.isEmpty()) return@collect
            val originalMessage = getMessageFromLink(boardMessage.content)
            sobbedMessages.put(boardMessage, getMessageLink(originalMessage))
        }
        updateBoard()
    }

    suspend fun updateBoard() {
        sobbedMessages.forEach { (_, originalMessage) ->
            val originalMessage: Message = getMessageFromLink(originalMessage)
            updateMessageFromMessage(originalMessage)
        }
    }

    suspend fun updateMessageFromMessage(originalMessage: Message) {
        val boardMessage = sobbedMessages.entries.find { it.value == getMessageLink(originalMessage) }?.key
        val sobs = originalMessage.reactions.filter { it.emoji.name == "\uD83D\uDE2D" }[0].data.count
        boardMessage?.edit {
            embed {
                description = if(originalMessage.embeds.isEmpty()) {
                    originalMessage.content
                } else {
                    originalMessage.embeds[0].description
                }
                author {
                    name = originalMessage.author?.username
                    icon = originalMessage.author?.avatar?.cdnUrl?.toUrl()
                }
                footer {
                    text = "$sobs 😭"
                }
            }
        }

    }

}