import cz.lukynka.hollow.RealmStorage
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

object SobBoardDatabase : RealmStorage<SobBoardDatabase.SobBoardMessage>(SobBoardMessage::class) {

    data class SobBoardMessage(
        @PrimaryKey
        val messageId: Long = 0,
        var sobs: Int = 0,
        val authorId: Long = 0,
        val originalMessageId: Long = 0,
        val channel: Long = 0,
    ) : RealmObject

}

