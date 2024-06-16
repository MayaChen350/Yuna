package embeds

import clickableButton
import dev.kord.common.Color
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.channel.asChannelOf
import dev.kord.core.behavior.channel.createEmbed
import dev.kord.core.entity.channel.TextChannel
import guildId
import kord

class Projects {

    suspend fun register() {
        val projectsChannel = kord.getGuild(guildId).getChannel(Snowflake(1249523281959059470)).asChannelOf<TextChannel>()
        projectsChannel.messages.collect { it.delete() }

        projectsChannel.createEmbed {
            title = "**__PrettyLog__**"
            description = """
                 A Kotlin logging library that makes your logs look more ✨ 𝙥𝙧𝙚𝙩𝙩𝙮 ✨ 
                    
                 **Languages:** `Kotlin`
                 ${clickableButton("Open on GitHub", "https://github.com/LukynkaCZE/PrettyLog")}
            """.trimIndent()
            color = Color(203, 166, 247)
            image = "https://private-user-images.githubusercontent.com/48604271/337748661-ee41b3a2-b2af-4ba8-a5d5-cfb7410b1065.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTc5ODM1MjIsIm5iZiI6MTcxNzk4MzIyMiwicGF0aCI6Ii80ODYwNDI3MS8zMzc3NDg2NjEtZWU0MWIzYTItYjJhZi00YmE4LWE1ZDUtY2ZiNzQxMGIxMDY1LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA2MTAlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNjEwVDAxMzM0MlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTVmMjMxYzJhYzAzZGYyNGY5MDJhYmIwOTgzZDNiNTkxMTU0NDIyMjQzZGQxMDg0ZmJjNGM4MTQ5NzFiZjFkNTUmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.7mM0YlSUlkRuCHx4fTW9m-ctjPLWN-d6neKmKKmnNfQ"
        }

        projectsChannel.createEmbed {
            title = "**__Lightweight Kotlin Web Server__**"
            description = """
                 LKWS A simple, easy to use and lightweight kotlin web server for small quick projects. No setup and boilerplate necessary, just import and use!
                    
                 **Languages:** `Kotlin`
                 ${clickableButton("Open on GitHub", "https://github.com/LukynkaCZE/LKWS/")}
            """.trimIndent()
            color = Color(203, 166, 247)
            image = "https://github.com/LukynkaCZE/LKWS/assets/48604271/e1838c5c-3586-43c5-8880-38c64c8b9371"
        }

        projectsChannel.createEmbed {
            title = "**__IntelliJ Twitch Channel Points Reward Integration__**"
            description = """
                 IntelliJ plugin that allows you to link your twitch channel point rewards to actions like changing theme, changing font, sending fake errors and etc.
                    
                 **Languages:** `Kotlin`
                 ${clickableButton("Open on GitHub", "https://github.com/LukynkaCZE/IntelliJTwitchChannelPoints")}
            """.trimIndent()
            color = Color(203, 166, 247)
            image = "https://private-user-images.githubusercontent.com/48604271/340070294-4e70f680-1dc4-4766-9cb3-883a86efd780.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTg1MzAxMTIsIm5iZiI6MTcxODUyOTgxMiwicGF0aCI6Ii80ODYwNDI3MS8zNDAwNzAyOTQtNGU3MGY2ODAtMWRjNC00NzY2LTljYjMtODgzYTg2ZWZkNzgwLmdpZj9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA2MTYlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNjE2VDA5MjMzMlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTk0YjI3ZWFmMDA0ZGEyYmE2MDdlZWQ5YzM1ZjRjYzFmNmRhMmJkNWUzNWJhZmZlMmMyMTAwZTdiZDAwYjNhMzAmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.4FIgkznMEPOxf7bi3jULYApGuar4WJpuBTTOyK4LpEM"
        }

        projectsChannel.createEmbed {
            title = "**__DockyardMC__**"
            description = """
                 DockyardMC is a open-source, fast and lightweight Minecraft server software that's written from scratch in Kotlin without any code from Mojang
                    
                 **Languages:** `Kotlin`
                 ${clickableButton("Open on GitHub", "https://github.com/DockyardMC/Dockyard/")}
            """.trimIndent()
            color = Color(203, 166, 247)
            image = "https://avatars.githubusercontent.com/u/135853618?s=400&u=c901e260edd4426828c6e0b3b4ad5be38dee6c4d&v=4"
        }

        projectsChannel.createEmbed {
            title = "**__Better Saved Hotbars__**"
            description = """
                 A mod that allows you to drag items into the saved hotbars tab and remove them by middle clicking! No need for saving entire hotbar with keybinds! 
                    
                 **Languages:** `Java`
                 ${clickableButton("Open on GitHub", "https://github.com/LukynkaCZE/better-saved-hotbars")}
            """.trimIndent()
            color = Color(250, 179, 135)
            image = "https://user-images.githubusercontent.com/48604271/235925525-e6b6a9f7-ef00-4148-ad51-6c8546ebcc55.gif"
        }

        // 👀 Why hello there code viewer!
        // 👀 For your efforts of going to this file on github,
        // 👀 you can look at *some* of my upcoming projects below!

        // 👀 keep it secret tho ;)


//        projectsChannel.createEmbed {
//            title = "**__Project Farmland__**"
//            description = """
//                 `Upcoming Project` `Temporary Name`
//
//                 An upcoming Stardew Valley and Origin Realms inspired cosy server that:
//                  - is built with the latest server technologies
//                  - has alternating seasons, day/night cycle and weather cycle
//                  - has romance-able/friendship-able NPCs that each have unique personality and story
//                  - has unique gameplay experience in the minecraft server space
//                  - lets you build your dream farm and customize it with hundreds of custom decorative models
//                  - has combat, farming, mining and fishing gameplay aspects
//                  - has custom music, textures, shaders and models
//                  - runs on the DockyardMC custom server implementation ${clickableButton("DockyardMC", "https://github.com/DockyardMC/Docykard")}
//
//
//                 **Languages:** `Kotlin`
//            """.trimIndent()
//            color = Color(166, 227, 161)
//        }
//
//        projectsChannel.createEmbed {
//            title = "**__Project Polaris__**"
//            description = """
//                 `Upcoming Project` `Temporary Name`
//
//                 An Upcoming Genshin Impact inspired open-world MMORPG action server that:
//                  - is built with the latest server technologies
//                  - is fully voice acted
//                  - has deep but easily-digestible lore and story
//                  - has satisfying but versatile elemental-based combat system
//                  - has custom music, textures, shaders and models
//                  - runs on the DockyardMC custom server implementation ${clickableButton("DockyardMC", "https://github.com/DockyardMC/Docykard")}
//                  - is fully open source!
//
//
//                 **Languages:** `Kotlin`
//            """.trimIndent()
//            color = Color(166, 227, 161)
//        }
    }
}