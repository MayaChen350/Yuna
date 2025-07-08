import cz.lukynka.hollow.Query
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.behavior.edit
import dev.kord.core.entity.Message
import dev.kord.rest.builder.message.MessageBuilder
import dev.kord.rest.builder.message.embed


object SobBoard {
    const val SOB_EMOJI = "😭"

    suspend fun addMessage(message: Message): SobBoardDatabase.SobBoardMessage {
        val boardMessage = sobChannel.createMessage {
            makeBoardMessage(message, message.getSobs())
        }

        val authorId: Long = message.getAuthorAsMember().id.value.toLong()
        val originalMessageId: Long = message.id.value.toLong()

        return SobBoardDatabase.SobBoardMessage(
            boardMessage.id.value.toLong(),
            authorId,
            originalMessageId
        ).also(SobBoardDatabase::write)
    }

    suspend inline fun updateOrCreateIf(originalMessage: Message, condition: () -> Boolean) {
        if (!updateMessage(originalMessage) && condition()) {
            addMessage(originalMessage)
        }
    }

    /**
     * Updates message already on sob board (in the db)
     *
     * @return false if the message is not on the sob board,
     * true otherwise
     */
    suspend fun updateMessage(originalMessage: Message): Boolean {
        val dbMessage = SobBoardDatabase.query(
            Query.Equals(
                "originalMessageId",
                originalMessage.id.value.toLong()
            )
        )
            .firstOrNull() ?: return false

        val boardMessage = sobChannel.getMessageOrNull(Snowflake(dbMessage.messageId))

        // the message is deleted or something
        if (boardMessage == null) {
            SobBoardDatabase.delete(dbMessage)

            addMessage(originalMessage)
            return true
        }

        boardMessage.edit {
            makeBoardMessage(originalMessage, originalMessage.getSobs())
        }

        return true
    }

    private suspend fun MessageBuilder.makeBoardMessage(message: Message, sobs: Int) {
        val descriptionString = StringBuilder()

        descriptionString.append(message.embeds.firstOrNull()?.description ?: message.content)

        for (attachment in message.attachments) {
            if (!attachment.isImage) descriptionString.appendLine(clickableButton("video", attachment.url))
        }

        content = message.getUrl()

        embed {
            description = descriptionString.toString()
            author {
                name = message.author?.username
                icon = message.author?.avatar?.cdnUrl?.toUrl()
            }
            footer {
                text = "$sobs $SOB_EMOJI"
            }
            timestamp = message.timestamp
        }
        for (attachment in message.attachments) {
            if (attachment.isImage) {
                embed {
                    image = attachment.url
                }
            }
        }
    }
}
