package xyz.terrific.utils

import xyz.terrific.Main

class SendDiscordMessage {
    companion object {

        private val logger: Logger = Logger("SendMsg");

        /**
         * Send Discord Message
         * @param message Message to send
         */
        fun send(message: String) {
            if (Main.CHANNEL_ID != "-1") {
                if (Main.TOKEN != "") {
                    HTTPUtils.post("https://discord.com/api/v9/channels/${Main.CHANNEL_ID}/messages", "content=${message}", token=Main.TOKEN)
                } else {
                    logger.error("Set Token before sending discord messages")
                }
            } else {
                logger.log("Set ChannelID before sending messages: '-set channelid <channelid>'")
            }
        }

        // fun send(channel_id: String, message: String) {
        //     if (Main.TOKEN != "") {
        //         val res: String = HTTPUtils.post("https://discord.com/api/v9/channels/${channel_id}/messages", "content=${message}", token=Main.TOKEN)
        //     } else {
        //         Main.addChatMessage("Set Token before sending discord messages")
        //     }
        // }

    }
}
