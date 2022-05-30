package xyz.terrific.functions

import xyz.terrific.Main
import xyz.terrific.Main.old_messages
import xyz.terrific.utils.ServerGetMessages

class OutputMessage {
    companion object {

        private val logger: Logger = Logger("Discord")

        fun update() {
            try {
                val messages = ServerGetMessages.getMessages()

                if (old_messages != null && messages != old_messages) {
                    for (message in messages) {
                        if (message in old_messages) continue


                        if (message != old_messages[old_messages.size - 1] && message != "\n" && message != null) {

                            logger.message(Main.CHANNEL_ID, message)

                        }
                    }
                }


                old_messages = messages
            } catch (e: Exception) {
                return
            }
        }

    }
}
