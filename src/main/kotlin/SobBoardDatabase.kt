import cz.lukynka.hollow.RealmStorage
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

object SobBoardDatabase : RealmStorage<SobBoardDatabase.SobBoardMessage>(SobBoardMessage::class) {

    class SobBoardMessage(
        @PrimaryKey
        var messageId: Long = 0,
        var authorId: Long = 0,
        var originalMessageId: Long = 0,
        var channel: Long = 0,
    ) : RealmObject {
        constructor() : this(0, 0, 0, 0)
    }
}

