package xyz.terrific.mod.utils

import xyz.terrific.mod.Main

class ServerGetMessages {
    companion object {

        fun getMessages(): List<String> {
            if (Main.CHANNELID != "-1") {
                val result: String = HTTPUtils.get("http://${Main.IP}:${Main.PORT}/:${Main.CHANNELID}")
                if (result == "invalid") {
                    return List<String>(1){""}
                }

                return result.split("\n<br>")
            }
            return List<String>(1){""}
        }

        fun getNewestMessage(): String {
            val messages: List<String> = getMessages()
            return messages[messages.size - 1]
        }

    }
}
