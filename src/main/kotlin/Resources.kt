import java.io.File
import java.io.InputStream

object Resources {

    fun getFile(path: String): File {
        return File(ClassLoader.getSystemResource(path).file)
    }

    fun getText(path: String): String {
        return getFile(path).readText()
    }

    private fun readVersion(): String {
        val inputStream: InputStream? = object {}.javaClass.getResourceAsStream("/yuna.ver")
        return inputStream!!.bufferedReader().use { it.readText() }.trim()
    }

    fun getVersion(): YunaVersionInfo {
        val raw = readVersion().split("|")
        return YunaVersionInfo(
            raw[0],
            raw[1],
            raw[2]
        )
    }

}