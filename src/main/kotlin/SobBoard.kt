import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.behavior.edit
import dev.kord.core.entity.Message
import dev.kord.rest.builder.message.embed


object SobBoard {

    suspend fun addMessage(message: Message) {
        var sobs = 0
        val authorId: Long = message.getAuthorAsMember().id.value.toLong()
        val originalMessageId: Long = message.id.value.toLong()

        val footer = StringBuilder()
        val descriptionString = StringBuilder()

        message.reactions.forEach { reaction ->
            if (sobEmojis.contains(reaction.emoji.name)) {
                sobs = reaction.count
                footer.append("${reaction.count} ${reaction.emoji.name}")
            }
        }

        if (message.embeds.isEmpty()) {
            descriptionString.append(message.content)
        } else {
            descriptionString.append(message.embeds[0].description)
        }
        for (attachment in message.attachments) {
            if (!attachment.isImage) descriptionString.appendLine("${clickableButton("video", attachment.url)}\n")
        }

        val boardMessage = sobChannel.createMessage {
            content = getMessageLink(message)
            embed {
                url = "https://example.com/"
                description = descriptionString.toString()
                author {
                    name = message.author?.username
                    icon = message.author?.avatar?.cdnUrl?.toUrl()
                }
                footer {
                    text = footer.toString()

                }
            }
            for (attachment in message.attachments) {
                if (attachment.isImage) {
                    embed {
                        url = "https://example.com/"
                        image = attachment.url
                    }
                }
            }
        }

        SobBoardDatabase.write(SobBoardDatabase.SobBoardMessage(boardMessage.id.value.toLong(), sobs, authorId, originalMessageId))
    }

    suspend fun getMessages() {
        SobBoardDatabase

        sobChannel.messages.collect { boardMessage ->
            if (boardMessage.author?.isBot == false || boardMessage.content.isEmpty()) return@collect
            val originalMessage = getMessageFromLink(boardMessage.content)
            sobbedMessages[boardMessage] = getMessageLink(originalMessage)
        }
        updateBoard()
    }

    private suspend fun updateBoard() {
        sobbedMessages.forEach { (_, message) ->
            val originalMessage: Message = getMessageFromLink(message)
            updateMessageFromMessage(originalMessage)
        }
    }

    suspend fun updateMessageFromMessage(originalMessage: Message) {
        val boardMessage = sobbedMessages.entries.find { it.value == getMessageLink(originalMessage) }?.key
        val footer = StringBuilder()
        val descriptionString = StringBuilder()
        originalMessage.reactions.forEach { reaction ->
            if (sobEmojis.contains(reaction.emoji.name)) footer.append("${reaction.count} ${reaction.emoji.name}")
        }

        if (originalMessage.embeds.isEmpty()) {
            descriptionString.append(originalMessage.content)
        } else {
            descriptionString.append(originalMessage.embeds[0].description)
        }
        for (attachment in originalMessage.attachments) {
            if (!attachment.isImage) descriptionString.appendLine(clickableButton("video", attachment.url))
        }

        boardMessage?.edit {
            embed {
                url = "https://example.com/"
                description = descriptionString.toString()
                author {
                    name = originalMessage.author?.username
                    icon = originalMessage.author?.avatar?.cdnUrl?.toUrl()
                }
                footer {
                    text = footer.toString()
                }
            }
            for (attachment in originalMessage.attachments) {
                if (attachment.isImage) {
                    embed {
                        url = "https://example.com/"
                        image = attachment.url
                    }
                }
            }
        }

    }
}