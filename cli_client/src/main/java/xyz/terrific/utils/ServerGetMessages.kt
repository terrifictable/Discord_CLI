package xyz.terrific.utils

import xyz.terrific.Main

class ServerGetMessages {
    companion object {

        /**
         * Get Message(s) from Server
         */
        fun getMessages(): List<String> {
            if (Main.CHANNEL_ID != "-1") {
                val result: String = HTTPUtils.get("http://${Main.IP}:${Main.PORT}/:${Main.CHANNEL_ID}")
                if (result == "invalid") {
                    return List<String>(1){""}
                }

                return result.split("\n<br>")
            }
            return List<String>(1){""}
        }

        /**
         * Gets Newest Message From Server
         */
        fun getNewestMessage(): String {
            val messages: List<String> = getMessages()
            return messages[messages.size - 1]
        }

    }
}
