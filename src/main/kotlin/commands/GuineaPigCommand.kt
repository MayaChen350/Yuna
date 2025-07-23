package commands

import dev.kord.common.Color
import dev.kord.core.behavior.interaction.response.DeferredPublicMessageInteractionResponseBehavior
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.entity.interaction.InteractionCommand
import dev.kord.rest.builder.message.embed
import guildId
import kord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GuineaPigCommand {

    suspend fun register() {
        kord.createGuildChatInputCommand(guildId, "piggie", "Gets random guinea pig") {}
    }

    companion object {
        private val client = HttpClient.newHttpClient()

        suspend fun handle(command: InteractionCommand, response: DeferredPublicMessageInteractionResponseBehavior) {
            val request = HttpRequest.newBuilder()
                .GET()
                .uri(URI("https://guineapigs.lukynka.cloud/"))
                .build()

            withContext(Dispatchers.IO) {
                val piggieResponseBody = client.send(request, HttpResponse.BodyHandlers.ofString()).body()
                val piggieResponse = Json.decodeFromString<Response>(piggieResponseBody)

                response.respond {
                    embed {
                        title = "Guinea Pig!"
                        color = Color(163, 138, 116)
                        image = piggieResponse.imageUrl
                        footer {
                            text = "This picture includes: ${piggieResponse.included}"
                        }
                    }
                }
            }
        }
    }
}

@Serializable
data class Response(
    val imageUrl: String,
    val included: String,
)