package xyz.terrific.mod.utils

import xyz.terrific.mod.Main

class SendDiscordMessage {
    companion object {

        fun send(message: String) {
            if (Main.CHANNELID != "-1") {
                if (Main.TOKEN != "") {
                    HTTPUtils.post("https://discord.com/api/v9/channels/${Main.CHANNELID}/messages", "content=${message}", token=Main.TOKEN)
                } else {
                    Main.addChatMessage("Set Token before sending discord messages")
                }
            } else {
                Main.addChatMessage("Set ChannelID before sending messages: '/dmc set channelid <channelid>'")
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
