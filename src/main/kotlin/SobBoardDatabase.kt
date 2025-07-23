import io.github.dockyard.cz.lukynka.hollow.HollowCache
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object SobBoardDatabase : HollowCache<SobBoardDatabase.SobBoardMessage>("sob_board_messages") {

    @Serializable
    class SobBoardMessage(
        var messageId: Long,
        var authorId: Long,
        var originalMessageId: Long,
        var channel: Long,
    )

    fun queryByMessageId(messageId: Long): SobBoardMessage? {
        return this.getAll().values.firstOrNull { it.messageId == messageId }
    }

    fun removeByValue(value: SobBoardMessage) {
        val uuid = getAll().reversed()[value] ?: return
        this.remove(uuid)
    }

    override fun serialize(value: SobBoardMessage): String {
        return Json.encodeToString(value)
    }

    override fun deserialize(string: String): SobBoardMessage {
        return Json.decodeFromString(string)
    }
}

fun <K, V> Map<K, V>.reversed(): Map<V, K> = this.entries.associate { (k, v) -> v to k }
