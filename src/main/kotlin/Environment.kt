import io.github.cdimascio.dotenv.Dotenv

object Environment {

    val dotenv = Dotenv.load()

    val DISCORD_TOKEN = dotenv.get("DISCORD_TOKEN") ?: ""
    val GUILD_ID = dotenv.get("GUILD_ID").toLong()
    val MEMBER_ROLE = dotenv.get("MEMBER_ROLE").toLong()
    val SOB_BOARD_CHANNEL = dotenv.get("SOB_BOARD_CHANNEL").toLong()
    val SOB_BOARD_REQUIREMENT = dotenv.get("SOB_BOARD_REQUIREMENT")?.toInt() ?: 2

}