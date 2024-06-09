import io.github.cdimascio.dotenv.Dotenv

object Environment {

    val dotenv = Dotenv.load()

    val DISCORD_TOKEN = dotenv.get("DISCORD_TOKEN") ?: ""
}